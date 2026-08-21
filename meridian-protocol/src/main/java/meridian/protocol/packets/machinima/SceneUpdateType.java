// Auto-generated - do not edit
package meridian.protocol.packets.machinima;

import meridian.protocol.io.ProtocolException;

public enum SceneUpdateType {
    Update(0),
    Play(1),
    Stop(2),
    Frame(3),
    Save(4);

    public static final SceneUpdateType[] VALUES = values();

    private final int value;

    SceneUpdateType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SceneUpdateType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("SceneUpdateType", value);
    }
}