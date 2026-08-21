// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ParticleCollisionBlockType {
    None(0),
    Air(1),
    Solid(2),
    All(3);

    public static final ParticleCollisionBlockType[] VALUES = values();

    private final int value;

    ParticleCollisionBlockType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ParticleCollisionBlockType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ParticleCollisionBlockType", value);
    }
}