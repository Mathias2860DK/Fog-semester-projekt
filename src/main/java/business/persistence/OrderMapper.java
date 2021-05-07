package business.persistence;

import business.exceptions.UserException;

import java.sql.*;
//en ordre indeholder en carport, derfor ...
public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public int insertOrder(int deliveryInfoId, int carportWidth, int carportLength, String roof, int shedWidth, int shedLength, Timestamp date, String status, double totalPrice, int roofPitch) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO `orders`" +
                    " (`delivery_info_id`," +
                    " `cp_width`, " +
                    " `cp_length`, " +
                    " `cp_roof_type`, " +
                    " `shed_width`, " +
                    " `shed_length`, " +
                    " `date`, " +
                    " `status`, " +
                    " `totalprice`, " +
                    "`roof_pitch`)" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, deliveryInfoId);
                ps.setInt(2, carportWidth);
                ps.setInt(3, carportLength);
                ps.setString(4, roof);
                ps.setInt(5, shedWidth);
                ps.setInt(6, shedLength);
                ps.setTimestamp(7,date);
                ps.setString(8,status);
                ps.setDouble(9, totalPrice);
                ps.setInt(10, roofPitch);


                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int orderId = ids.getInt(1);


                return orderId;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
