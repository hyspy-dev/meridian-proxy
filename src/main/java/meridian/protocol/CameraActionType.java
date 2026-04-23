/*
 * Decompiled with CFR 0.152.
 */
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum CameraActionType {
    ForcePerspective(0),
    Orbit(1),
    Transition(2);

    public static final CameraActionType[] VALUES;
    private final int value;

    private CameraActionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static CameraActionType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("CameraActionType", value);
    }

    static {
        VALUES = CameraActionType.values();
    }
}

