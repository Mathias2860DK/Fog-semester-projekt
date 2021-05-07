package business.persistence;

import business.entities.DeliveryInfo;
import business.exceptions.UserException;
import business.services.DeliveryInfoFacade;

import java.sql.*;

public class DeliveryInfoMapper {
    private Database database;

    public DeliveryInfoMapper(Database database) {
        this.database = database;
    }
    public int insertDeliveryInfo(DeliveryInfo deliveryInfo) throws UserException {

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
                ps.setInt(1, deliveryInfo.getUserId());
                ps.setString(2, deliveryInfo.getName());
                ps.setString(3, deliveryInfo.getAddress());
                ps.setString(4, deliveryInfo.getZipCodeCity());
                ps.setInt(5, deliveryInfo.getPhone());
                ps.setString(6, deliveryInfo.getEmail());
                ps.setString(7, deliveryInfo.getRemarks());


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
