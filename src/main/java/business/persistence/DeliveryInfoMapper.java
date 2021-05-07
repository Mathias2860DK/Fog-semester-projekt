package business.persistence;

import business.exceptions.UserException;

import java.sql.*;

public class DeliveryInfoMapper {
    private Database database;

    public DeliveryInfoMapper(Database database) {
        this.database = database;
    }
    public int insertDeliveryInfo(int userId, String name, String address, String zipCodeCity, int phone, String email, String remarks) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO `orders`" +
                    " (`user_id`," +
                    " `name`, " +
                    " `address`, " +
                    " `zipcode_city`, " +
                    " `phone`, " +
                    " `email`, " +
                    "`remarks`)" +
                    " VALUES (?,?,?,?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, userId);
                ps.setString(2, name);
                ps.setString(3, address);
                ps.setString(4, zipCodeCity);
                ps.setInt(5, phone);
                ps.setString(6, email);
                ps.setString(7,remarks);


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int deliveryInfoId = ids.getInt(1);


                return deliveryInfoId;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
