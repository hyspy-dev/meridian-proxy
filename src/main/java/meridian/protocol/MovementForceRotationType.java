/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum MovementForceRotationType {
    AttachedToHead(0),
    CameraRotation(1),
    Custom(2);

    public static final MovementForceRotationType[] VALUES;
    private final int value;

    private MovementForceRotationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static MovementForceRotationType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("MovementForceRotationType", value);
    }

    static {
        VALUES = MovementForceRotationType.values();
    }
}

