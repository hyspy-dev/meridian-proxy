/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum MountController {
    Minecart(0),
    BlockMount(1);

    public static final MountController[] VALUES;
    private final int value;

    private MountController(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static MountController fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("MountController", value);
    }

    static {
        VALUES = MountController.values();
    }
}

