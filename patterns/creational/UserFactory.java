package patterns.creational;

import model.User;
import model.StandardUser;
import model.VIPUser;

public interface UserFactory {
    User create(String username);
}