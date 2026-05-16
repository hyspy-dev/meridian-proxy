package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum InteractionTarget {
   User(0),
   Owner(1),
   Target(2);

   public static final InteractionTarget[] VALUES = values();
   private final int value;

   InteractionTarget(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static InteractionTarget fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("InteractionTarget", value);
      }
   }
}
