/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ModifierTarget {
    Min(0),
    Max(1);

    public static final ModifierTarget[] VALUES;
    private final int value;

    private ModifierTarget(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ModifierTarget fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ModifierTarget", value);
    }

    static {
        VALUES = ModifierTarget.values();
    }
}

