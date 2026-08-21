// Auto-generated - do not edit
package meridian.protocol;

public final class ModelTransformFields {
    private ModelTransformFields() {
    }

    public static final short None = (short) 0;
    public static final short PositionX = (short) 1;
    public static final short PositionY = (short) 2;
    public static final short PositionZ = (short) 4;
    public static final short BodyOrientationYaw = (short) 8;
    public static final short BodyOrientationPitch = (short) 16;
    public static final short BodyOrientationRoll = (short) 32;
    public static final short LookOrientationYaw = (short) 64;
    public static final short LookOrientationPitch = (short) 128;
    public static final short LookOrientationRoll = (short) 256;
    public static final short ALL = (short) 511;

    public static boolean has(short value, short flag) {
        return (value & flag) == flag;
    }

    public static short with(short value, short flag) {
        return (short) (value | flag);
    }

    public static short without(short value, short flag) {
        return (short) (value & ~flag);
    }

    public static short none() {
        return (short) 0;
    }
}