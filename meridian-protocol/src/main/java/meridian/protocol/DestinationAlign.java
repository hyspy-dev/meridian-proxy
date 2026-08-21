// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum DestinationAlign {
    EntryMarker(0),
    NamedMarker(1),
    SamePosition(2);

    public static final DestinationAlign[] VALUES = values();

    private final int value;

    DestinationAlign(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DestinationAlign fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("DestinationAlign", value);
    }
}