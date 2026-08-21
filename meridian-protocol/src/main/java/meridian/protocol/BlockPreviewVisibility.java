// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum BlockPreviewVisibility {
    AlwaysVisible(0),
    AlwaysHidden(1),
    Default(2);

    public static final BlockPreviewVisibility[] VALUES = values();

    private final int value;

    BlockPreviewVisibility(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BlockPreviewVisibility fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("BlockPreviewVisibility", value);
    }
}