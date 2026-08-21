// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum Opacity {
    Solid(0),
    Semitransparent(1),
    Cutout(2),
    Transparent(3);

    public static final Opacity[] VALUES = values();

    private final int value;

    Opacity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Opacity fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("Opacity", value);
    }
}