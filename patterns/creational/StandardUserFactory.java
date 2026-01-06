package patterns.creational;
import model.User;
import model.StandardUser;

// The Concrete Creator for Standard Users
public class StandardUserFactory implements UserFactory {
    private static final double DEFAULT_BALANCE = 100.00;

    @Override
    public User create(String username) {
        // This subclass decides exactly how to make a Standard User
        return new StandardUser(username, DEFAULT_BALANCE);
    }
}