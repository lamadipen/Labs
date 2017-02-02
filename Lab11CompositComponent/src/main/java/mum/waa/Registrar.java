package mum.waa;

import java.util.ArrayList;
import java.util.List;

public class Registrar {

   private static List<User> registeredUsers = new ArrayList<User>();
   static {
      registeredUsers.add(new User("dipen", "lama"));
   }

   public static void register(String name, String password) {
      registeredUsers.add(new User(name, password));
   }

   public static boolean isRegistered(String name, String password) {
      for (User user : registeredUsers) {
         if (user.getName().equals(name) && user.getPassword().equals(password))
            return true;
      }
      return false;
   }
}
