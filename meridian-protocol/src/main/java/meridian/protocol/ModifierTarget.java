package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ModifierTarget {
   Min(0),
   Max(1);

   public static final ModifierTarget[] VALUES = values();
   private final int value;

   ModifierTarget(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static ModifierTarget fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("ModifierTarget", value);
      }
   }
}
