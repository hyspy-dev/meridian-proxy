/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum DebugFlags {
    Fade(0),
    NoWireframe(1),
    NoSolid(2);

    public static final DebugFlags[] VALUES;
    private final int value;

    private DebugFlags(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static DebugFlags fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("DebugFlags", value);
    }

    static {
        VALUES = DebugFlags.values();
    }
}

