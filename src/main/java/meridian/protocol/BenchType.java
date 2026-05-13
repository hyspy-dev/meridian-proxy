package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum BenchType {
   Crafting(0),
   Processing(1),
   DiagramCrafting(2),
   StructuralCrafting(3);

   public static final BenchType[] VALUES = values();
   private final int value;

   BenchType(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static BenchType fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("BenchType", value);
      }
   }
}
