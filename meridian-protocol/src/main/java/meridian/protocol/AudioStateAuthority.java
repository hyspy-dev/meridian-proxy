// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum AudioStateAuthority {
    Server(0),
    Client(1);

    public static final AudioStateAuthority[] VALUES = values();

    private final int value;

    AudioStateAuthority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AudioStateAuthority fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("AudioStateAuthority", value);
    }
}