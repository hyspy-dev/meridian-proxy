package meridian.internal.control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import meridian.protocol.Packet;
import meridian.protocol.PacketRegistry;

/**
 * Protocol packets as JSON and back, for the control channel.
 *
 * <p>The protocol classes are plain objects with public fields and a no-argument constructor, so
 * Gson reads and writes them as they are. Three things need help: the vector interfaces
 * ({@code Vector3fc} and kin) are read as their plain classes; a {@code byte[]} travels as base64
 * (a number array is read too); and for watching, long strings and arrays are cut short so a chunk
 * does not flood the screen.
 */
public final class PacketJson {

    /** Strings longer than this are cut when a packet is shown (not when it is sent). */
    private static final int SHOW_STRING_MAX = 300;
    /** Arrays longer than this are cut when a packet is shown. */
    private static final int SHOW_ARRAY_MAX = 48;

    public static final Gson GSON = new GsonBuilder()
            .serializeSpecialFloatingPointValues()
            .disableHtmlEscaping()
            .registerTypeAdapter(byte[].class, new BytesAdapter())
            .registerTypeAdapter(org.joml.Vector2fc.class, concrete(org.joml.Vector2f.class))
            .registerTypeAdapter(org.joml.Vector3fc.class, concrete(org.joml.Vector3f.class))
            .registerTypeAdapter(org.joml.Vector4fc.class, concrete(org.joml.Vector4f.class))
            .create();

    private PacketJson() {
    }

    /** A packet as a JSON tree, whole. */
    public static JsonElement toTree(Object packet) {
        return GSON.toJsonTree(packet);
    }

    /** A packet as a JSON tree with long strings and arrays cut, for showing. */
    public static JsonElement toShortTree(Object packet) {
        return shorten(toTree(packet));
    }

    /** The packet class {@code name} names for a direction, or {@code null}: a simple class name, any case, or an id. */
    public static PacketRegistry.PacketInfo find(String name, boolean toServer) {
        if (name == null || name.isBlank()) {
            return null;
        }
        try {
            int id = Integer.parseInt(name.trim());
            return toServer ? PacketRegistry.getToServerPacketById(id) : PacketRegistry.getToClientPacketById(id);
        } catch (NumberFormatException notAnId) {
            // a name
        }
        String want = name.trim().toLowerCase(Locale.ROOT);
        for (PacketRegistry.PacketInfo any : PacketRegistry.all().values()) {
            if (any.name().toLowerCase(Locale.ROOT).equals(want)
                    || any.type().getSimpleName().toLowerCase(Locale.ROOT).equals(want)) {
                return toServer ? PacketRegistry.getToServerPacketById(any.id())
                        : PacketRegistry.getToClientPacketById(any.id());
            }
        }
        return null;
    }

    /** Every packet the protocol knows, for the {@code packets} command: id, name, channel, directions. */
    public static List<JsonObject> catalog(String filter) {
        String f = filter == null ? "" : filter.toLowerCase(Locale.ROOT);
        List<JsonObject> out = new ArrayList<>();
        for (Map.Entry<Integer, PacketRegistry.PacketInfo> e : PacketRegistry.all().entrySet()) {
            PacketRegistry.PacketInfo info = e.getValue();
            if (!f.isEmpty() && !info.name().toLowerCase(Locale.ROOT).contains(f)) {
                continue;
            }
            JsonObject o = new JsonObject();
            o.addProperty("id", info.id());
            o.addProperty("name", info.name());
            o.addProperty("channel", info.channel().name());
            boolean c2s = PacketRegistry.getToServerPacketById(info.id()) != null;
            boolean s2c = PacketRegistry.getToClientPacketById(info.id()) != null;
            o.addProperty("dir", c2s && s2c ? "both" : c2s ? "c2s" : "s2c");
            out.add(o);
        }
        out.sort((a, b) -> Integer.compare(a.get("id").getAsInt(), b.get("id").getAsInt()));
        return out;
    }

    /** Builds a packet of {@code info}'s class from JSON; {@code {}} or blank gives its defaults. */
    public static Packet fromJson(PacketRegistry.PacketInfo info, String json) {
        String body = json == null || json.isBlank() ? "{}" : json;
        return GSON.fromJson(body, info.type());
    }

    // ------------------------------------------------------------------

    static JsonElement shorten(JsonElement e) {
        if (e == null || e.isJsonNull()) {
            return e;
        }
        if (e.isJsonPrimitive()) {
            JsonPrimitive p = e.getAsJsonPrimitive();
            if (p.isString() && p.getAsString().length() > SHOW_STRING_MAX) {
                String s = p.getAsString();
                return new JsonPrimitive(s.substring(0, SHOW_STRING_MAX) + "...(" + s.length() + " chars)");
            }
            return e;
        }
        if (e.isJsonArray()) {
            JsonArray a = e.getAsJsonArray();
            JsonArray out = new JsonArray();
            int n = Math.min(a.size(), SHOW_ARRAY_MAX);
            for (int i = 0; i < n; i++) {
                out.add(shorten(a.get(i)));
            }
            if (a.size() > n) {
                out.add("...(" + a.size() + " items)");
            }
            return out;
        }
        JsonObject o = e.getAsJsonObject();
        JsonObject out = new JsonObject();
        for (Map.Entry<String, JsonElement> f : o.entrySet()) {
            out.add(f.getKey(), shorten(f.getValue()));
        }
        return out;
    }

    /** Reads an interface type as one plain class, writes whatever it is. */
    private static <T> TypeAdapter<T> concrete(Class<? extends T> as) {
        return new TypeAdapter<>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    GSON_PLAIN.toJson(value, value.getClass(), out);
                }
            }

            @Override
            public T read(JsonReader in) throws IOException {
                return GSON_PLAIN.fromJson(in, as);
            }
        };
    }

    /** Gson without our adapters, for the plain vector classes the adapters hand over. */
    private static final Gson GSON_PLAIN = new GsonBuilder().serializeSpecialFloatingPointValues().create();

    private static final class BytesAdapter extends TypeAdapter<byte[]> {
        @Override
        public void write(JsonWriter out, byte[] value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(Base64.getEncoder().encodeToString(value));
            }
        }

        @Override
        public byte[] read(JsonReader in) throws IOException {
            JsonToken t = in.peek();
            if (t == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            if (t == JsonToken.STRING) {
                return Base64.getDecoder().decode(in.nextString());
            }
            List<Integer> values = new ArrayList<>();
            in.beginArray();
            while (in.hasNext()) {
                values.add(in.nextInt());
            }
            in.endArray();
            byte[] out = new byte[values.size()];
            for (int i = 0; i < out.length; i++) {
                out[i] = (byte) (int) values.get(i);
            }
            return out;
        }
    }
}
