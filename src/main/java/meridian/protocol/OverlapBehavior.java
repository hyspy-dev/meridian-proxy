/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum OverlapBehavior {
    Extend(0),
    Overwrite(1),
    Ignore(2);

    public static final OverlapBehavior[] VALUES;
    private final int value;

    private OverlapBehavior(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static OverlapBehavior fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("OverlapBehavior", value);
    }

    static {
        VALUES = OverlapBehavior.values();
    }
}

