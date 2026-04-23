/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol.packets.world;

import meridian.protocol.io.ProtocolException;

public enum RotationDirection {
    Positive(0),
    Negative(1);

    public static final RotationDirection[] VALUES;
    private final int value;

    private RotationDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static RotationDirection fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("RotationDirection", value);
    }

    static {
        VALUES = RotationDirection.values();
    }
}

