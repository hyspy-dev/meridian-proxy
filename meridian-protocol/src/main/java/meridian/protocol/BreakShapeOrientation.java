// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum BreakShapeOrientation {
    View(0),
    Surface(1);

    public static final BreakShapeOrientation[] VALUES = values();

    private final int value;

    BreakShapeOrientation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BreakShapeOrientation fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("BreakShapeOrientation", value);
    }
}