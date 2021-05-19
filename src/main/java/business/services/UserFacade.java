package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

/**
 * The UserFacade class uses the Facade Design Pattern and hides the complexity of the UserMapper class
 */
public class UserFacade {
    UserMapper userMapper;

    /**
     * @param database The database the UserFacade class uses.
     */
    public UserFacade(Database database) {
        userMapper = new UserMapper(database);
    }

    /**
     * @param email    The email used for logging in
     * @param password The password used for logging in
     * @return Calls the UserMapper's login method, with the parameters provided in this method
     * @throws UserException If something goes wrong
     */
    public User login(String email, String password) throws UserException {
        return userMapper.login(email, password);
    }

    /**
     * @param email    email
     * @param password password
     * @return the newly created user
     * @throws UserException If something goes wrong
     */
    public User createUser(String email, String password) throws UserException {
        User user = new User(email, password, "customer");
        userMapper.createUser(user);
        return user;
    }

}
