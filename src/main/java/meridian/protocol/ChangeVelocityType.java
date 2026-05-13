package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ChangeVelocityType {
   Add(0),
   Set(1);

   public static final ChangeVelocityType[] VALUES = values();
   private final int value;

   ChangeVelocityType(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static ChangeVelocityType fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("ChangeVelocityType", value);
      }
   }
}
