package meridian.protocol.packets.connection;

import meridian.protocol.io.ProtocolException;

public enum DisconnectType {
   Disconnect(0),
   Crash(1);

   public static final DisconnectType[] VALUES = values();
   private final int value;

   DisconnectType(int value) {
      this.value = value;
   }

   public int getValue() {
      return this.value;
   }

   public static DisconnectType fromValue(int value) {
      if (value >= 0 && value < VALUES.length) {
         return VALUES[value];
      } else {
         throw ProtocolException.invalidEnumValue("DisconnectType", value);
      }
   }
}
