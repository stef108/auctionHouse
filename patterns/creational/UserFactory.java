package patterns.creational;

import model.User;
import model.StandardUser;
import model.VIPUser;

public class UserFactory {
//    Factory pattern, with the shared User interface, the factory can create multiple kinds of users.

    private static final double VIP_STARTING_BALANCE = 50000.00;
    private static final double STANDARD_STARTING_BALANCE = 0.50;  // Yes, really

    public static User createUser(String type, String username, double balance) {
        if (type.equalsIgnoreCase("VIP")) {
            return new VIPUser(username, balance);
        }
        else if (type.equalsIgnoreCase("STANDARD")) {
            return new StandardUser(username, balance);
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }
}
