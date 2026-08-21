// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum EffectOp {
    Add(0),
    Remove(1);

    public static final EffectOp[] VALUES = values();

    private final int value;

    EffectOp(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EffectOp fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("EffectOp", value);
    }
}