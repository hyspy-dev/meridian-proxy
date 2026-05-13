package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum WaitForDataFrom {
   Client(0),
   Server(1),
   None(2);

   public static final WaitForDataFrom[] VALUES = values();
   private final int value;

   WaitForDataFrom(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static WaitForDataFrom fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("WaitForDataFrom", value);
      }
   }
}
