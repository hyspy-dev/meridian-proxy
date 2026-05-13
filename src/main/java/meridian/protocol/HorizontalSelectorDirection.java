package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum HorizontalSelectorDirection {
   ToLeft(0),
   ToRight(1);

   public static final HorizontalSelectorDirection[] VALUES = values();
   private final int value;

   HorizontalSelectorDirection(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static HorizontalSelectorDirection fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("HorizontalSelectorDirection", value);
      }
   }
}
