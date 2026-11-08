package meridian.internal.module;

import java.util.Map;
import java.util.TreeMap;
import meridian.api.command.ControlCommand;

/**
 * The command-channel commands the modules of one runtime offer - one runtime per connection, so
 * these act on that connection (see {@link ControlCommand}).
 */
public final class CommandRegistry {

    /** One registered command. */
    public record Entry(String module, String name, String usage, ControlCommand command) {
    }

    private final Map<String, Entry> byName = new TreeMap<>();

    synchronized void register(String module, String name, String usage, ControlCommand command) {
        if (name == null || name.isBlank() || command == null) {
            return;
        }
        byName.put(name.toLowerCase(java.util.Locale.ROOT), new Entry(module, name, usage, command));
    }

    public synchronized Entry get(String name) {
        return name == null ? null : byName.get(name.toLowerCase(java.util.Locale.ROOT));
    }

    public synchronized java.util.List<Entry> all() {
        return java.util.List.copyOf(byName.values());
    }
}
