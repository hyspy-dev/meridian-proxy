// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum PrioritySlot {
    Default(0),
    MainHand(1),
    OffHand(2);

    public static final PrioritySlot[] VALUES = values();

    private final int value;

    PrioritySlot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PrioritySlot fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("PrioritySlot", value);
    }
}