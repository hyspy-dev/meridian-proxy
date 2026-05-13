package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum RoofState {
   Any(0),
   Roofed(1),
   Unroofed(2);

   public static final RoofState[] VALUES = values();
   private final int value;

   RoofState(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static RoofState fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("RoofState", value);
      }
   }
}
