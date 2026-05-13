package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ItemHudUIType {
   Hud(0),
   Legend(1);

   public static final ItemHudUIType[] VALUES = values();
   private final int value;

   ItemHudUIType(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static ItemHudUIType fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("ItemHudUIType", value);
      }
   }
}
