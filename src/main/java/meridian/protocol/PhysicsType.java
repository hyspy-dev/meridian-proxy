/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum PhysicsType {
    Standard(0);

    public static final PhysicsType[] VALUES;
    private final int value;

    private PhysicsType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static PhysicsType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("PhysicsType", value);
    }

    static {
        VALUES = PhysicsType.values();
    }
}

