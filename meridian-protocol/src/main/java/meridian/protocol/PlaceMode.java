// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum PlaceMode {
    Default(0),
    Replace(1),
    Retype(2),
    Extrude(3),
    SurfaceDraw(4),
    FastPlace(5);

    public static final PlaceMode[] VALUES = values();

    private final int value;

    PlaceMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PlaceMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("PlaceMode", value);
    }
}