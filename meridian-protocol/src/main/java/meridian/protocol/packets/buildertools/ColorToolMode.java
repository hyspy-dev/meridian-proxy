// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import meridian.protocol.io.ProtocolException;

public enum ColorToolMode {
    Coloring(0),
    Gradient(1),
    Shading(2);

    public static final ColorToolMode[] VALUES = values();

    private final int value;

    ColorToolMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ColorToolMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ColorToolMode", value);
    }
}