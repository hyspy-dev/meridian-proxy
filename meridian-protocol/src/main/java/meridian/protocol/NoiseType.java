// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum NoiseType {
    Sin(0),
    Cos(1),
    Perlin_Linear(2),
    Perlin_Hermite(3),
    Perlin_Quintic(4),
    Random(5);

    public static final NoiseType[] VALUES = values();

    private final int value;

    NoiseType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static NoiseType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("NoiseType", value);
    }
}