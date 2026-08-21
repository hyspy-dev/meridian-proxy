// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum FXRenderMode {
    BlendLinear(0),
    BlendAdd(1),
    Erosion(2),
    Distortion(3);

    public static final FXRenderMode[] VALUES = values();

    private final int value;

    FXRenderMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FXRenderMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("FXRenderMode", value);
    }
}