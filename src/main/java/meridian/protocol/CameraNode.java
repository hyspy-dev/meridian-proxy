/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum CameraNode {
    None(0),
    Head(1),
    LShoulder(2),
    RShoulder(3),
    Belly(4);

    public static final CameraNode[] VALUES;
    private final int value;

    private CameraNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static CameraNode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("CameraNode", value);
    }

    static {
        VALUES = CameraNode.values();
    }
}

