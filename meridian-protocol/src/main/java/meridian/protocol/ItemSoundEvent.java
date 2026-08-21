// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ItemSoundEvent {
    Drag(0),
    Drop(1);

    public static final ItemSoundEvent[] VALUES = values();

    private final int value;

    ItemSoundEvent(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemSoundEvent fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ItemSoundEvent", value);
    }
}