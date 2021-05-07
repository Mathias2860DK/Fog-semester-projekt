package business.persistence;

import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
//en ordre indeholder en carport, derfor ...
public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public int insertOrder(Carport carport, Order order, int deliveryInfoId) throws UserException {

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
                ps.setInt(2, carport.getCarportWidth());
                ps.setInt(3,  carport.getCarportLength());
                ps.setString(4, carport.getRoof());
                ps.setInt(5, 0);//carport.getShedWidth());
                ps.setInt(6, 0);//getShedLength);
                ps.setTimestamp(7,order.getDate());
                ps.setString(8,order.getStatus());
                ps.setDouble(9, order.getTotalprice());
                ps.setInt(10, carport.getRoofPitch());


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
