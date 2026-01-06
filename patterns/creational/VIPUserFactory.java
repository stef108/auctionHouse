package patterns.creational;
import model.User;
import model.VIPUser;

// The Concrete Creator for VIP Users
public class VIPUserFactory implements UserFactory {
    private static final double DEFAULT_BALANCE = 50000.00;

    @Override
    public User create(String username) {
        // This subclass decides exactly how to make a VIP User
        return new VIPUser(username, DEFAULT_BALANCE);
    }
}