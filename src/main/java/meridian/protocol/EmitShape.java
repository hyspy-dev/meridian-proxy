/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum EmitShape {
    Sphere(0),
    Cube(1);

    public static final EmitShape[] VALUES;
    private final int value;

    private EmitShape(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static EmitShape fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("EmitShape", value);
    }

    static {
        VALUES = EmitShape.values();
    }
}

