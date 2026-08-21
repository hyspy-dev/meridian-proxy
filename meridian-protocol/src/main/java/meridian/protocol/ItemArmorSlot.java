// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ItemArmorSlot {
    Head(0),
    Chest(1),
    Hands(2),
    Legs(3);

    public static final ItemArmorSlot[] VALUES = values();

    private final int value;

    ItemArmorSlot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemArmorSlot fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ItemArmorSlot", value);
    }
}