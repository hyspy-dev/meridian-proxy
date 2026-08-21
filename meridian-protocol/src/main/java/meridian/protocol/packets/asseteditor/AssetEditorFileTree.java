// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import meridian.protocol.io.ProtocolException;

public enum AssetEditorFileTree {
    Server(0),
    Common(1);

    public static final AssetEditorFileTree[] VALUES = values();

    private final int value;

    AssetEditorFileTree(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AssetEditorFileTree fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("AssetEditorFileTree", value);
    }
}