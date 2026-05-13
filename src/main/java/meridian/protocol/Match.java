package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum Match {
   All(0),
   None(1);

   public static final Match[] VALUES = values();
   private final int value;

   Match(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static Match fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("Match", value);
      }
   }
}
