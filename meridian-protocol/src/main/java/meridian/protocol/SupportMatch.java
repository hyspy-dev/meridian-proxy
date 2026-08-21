// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum SupportMatch {
    Ignored(0),
    Required(1),
    Disallowed(2);

    public static final SupportMatch[] VALUES = values();

    private final int value;

    SupportMatch(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SupportMatch fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("SupportMatch", value);
    }
}