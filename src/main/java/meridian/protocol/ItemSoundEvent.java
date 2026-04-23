/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ItemSoundEvent {
    Drag(0),
    Drop(1);

    public static final ItemSoundEvent[] VALUES;
    private final int value;

    private ItemSoundEvent(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ItemSoundEvent fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ItemSoundEvent", value);
    }

    static {
        VALUES = ItemSoundEvent.values();
    }
}

