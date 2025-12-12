package patterns.creational;

import model.User;
import model.StandardUser;
import model.VIPUser;

public class UserFactory {
//    Factory pattern, with the shared User interface, the factory can create multiple kinds of users.

    private static final double VIP_STARTING_BALANCE = 50000.00;
    private static final double STANDARD_STARTING_BALANCE = 1000.00;

    public static User createUser(String type, String username) {
        if (type.equalsIgnoreCase("VIP")) {
            return new VIPUser(username, VIP_STARTING_BALANCE);
        }
        else if (type.equalsIgnoreCase("STANDARD")) {
            return new StandardUser(username, STANDARD_STARTING_BALANCE);
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }
}
