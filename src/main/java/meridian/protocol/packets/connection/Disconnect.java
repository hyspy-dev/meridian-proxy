/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol.packets.connection;

import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToClientPacket;
import meridian.protocol.ToServerPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ValidationResult;
import meridian.protocol.io.VarInt;
import meridian.protocol.packets.connection.DisconnectType;
import io.netty.buffer.ByteBuf;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Disconnect
implements Packet,
ToServerPacket,
ToClientPacket {
    public static final int PACKET_ID = 1;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 16384007;
    @Nullable
    public String reason;
    @Nonnull
    public DisconnectType type = DisconnectType.Disconnect;

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public Disconnect() {
    }

    public Disconnect(@Nullable String reason, @Nonnull DisconnectType type) {
        this.reason = reason;
        this.type = type;
    }

    public Disconnect(@Nonnull Disconnect other) {
        this.reason = other.reason;
        this.type = other.type;
    }

    @Nonnull
    public static Disconnect deserialize(@Nonnull ByteBuf buf, int offset) {
        Disconnect obj = new Disconnect();
        byte nullBits = buf.getByte(offset);
        obj.type = DisconnectType.fromValue(buf.getByte(offset + 1));
        int pos = offset + 2;
        if ((nullBits & 1) != 0) {
            int reasonLen = VarInt.peek(buf, pos);
            if (reasonLen < 0) {
                throw ProtocolException.negativeLength("Reason", reasonLen);
            }
            if (reasonLen > 4096000) {
                throw ProtocolException.stringTooLong("Reason", reasonLen, 4096000);
            }
            int reasonVarLen = VarInt.length(buf, pos);
            obj.reason = PacketIO.readVarString(buf, pos, PacketIO.UTF8);
            pos += reasonVarLen + reasonLen;
        }
        return obj;
    }

    public static int computeBytesConsumed(@Nonnull ByteBuf buf, int offset) {
        byte nullBits = buf.getByte(offset);
        int pos = offset + 2;
        if ((nullBits & 1) != 0) {
            int sl = VarInt.peek(buf, pos);
            pos += VarInt.length(buf, pos) + sl;
        }
        return pos - offset;
    }

    @Override
    public void serialize(@Nonnull ByteBuf buf) {
        int nullBits = 0;
        if (this.reason != null) {
            nullBits = (byte)(nullBits | 1);
        }
        buf.writeByte(nullBits);
        buf.writeByte(this.type.getValue());
        if (this.reason != null) {
            PacketIO.writeVarString(buf, this.reason, 4096000);
        }
    }

    @Override
    public int computeSize() {
        int size = 2;
        if (this.reason != null) {
            size += PacketIO.stringSize(this.reason);
        }
        return size;
    }

    public static ValidationResult validateStructure(@Nonnull ByteBuf buffer, int offset) {
        if (buffer.readableBytes() - offset < 2) {
            return ValidationResult.error("Buffer too small: expected at least 2 bytes");
        }
        byte nullBits = buffer.getByte(offset);
        int pos = offset + 2;
        if ((nullBits & 1) != 0) {
            int reasonLen = VarInt.peek(buffer, pos);
            if (reasonLen < 0) {
                return ValidationResult.error("Invalid string length for Reason");
            }
            if (reasonLen > 4096000) {
                return ValidationResult.error("Reason exceeds max length 4096000");
            }
            pos += VarInt.length(buffer, pos);
            if ((pos += reasonLen) > buffer.writerIndex()) {
                return ValidationResult.error("Buffer overflow reading Reason");
            }
        }
        return ValidationResult.OK;
    }

    public Disconnect clone() {
        Disconnect copy = new Disconnect();
        copy.reason = this.reason;
        copy.type = this.type;
        return copy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Disconnect)) {
            return false;
        }
        Disconnect other = (Disconnect)obj;
        return Objects.equals(this.reason, other.reason) && Objects.equals((Object)this.type, (Object)other.type);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.reason, this.type});
    }
}

