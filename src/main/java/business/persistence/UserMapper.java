package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

/**
 * The UserMapper class function is retrieve,delete and insert into the database via SQL-queries
 *
 */
public class UserMapper {
    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

//Creates user in the database
    /**
     *
     * @param user The Users data
     * @throws UserException If something goes wrong
     */
    public void createUser(User user) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.executeUpdate();

                //Gets the returned keys from the database
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                //Sets the id retrieved from the database.
                user.setId(id);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    /**
     *
     * @param email Login email
     * @param password password
     * @return The user
     * @throws UserException If something goes wrong.
     */
    public User login(String email, String password) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT id, role FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    User user = new User(email, password, role);
                    user.setId(id);
                    return user;
                } else {
                    throw new UserException("Could not validate user");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

}
