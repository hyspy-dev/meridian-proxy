package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum InventoryActionType {
   TakeAll(0),
   PutAll(1),
   QuickStack(2),
   Sort(3);

   public static final InventoryActionType[] VALUES = values();
   private final int value;

   InventoryActionType(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static InventoryActionType fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("InventoryActionType", value);
      }
   }
}
