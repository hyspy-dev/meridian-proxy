// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import meridian.protocol.io.ProtocolException;

public enum EntityToolAction {
    Remove(0),
    Clone(1),
    Freeze(2);

    public static final EntityToolAction[] VALUES = values();

    private final int value;

    EntityToolAction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EntityToolAction fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("EntityToolAction", value);
    }
}