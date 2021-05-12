package business.persistence;

import business.entities.Carport;
import business.entities.Order;
import business.entities.Shed;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//en ordre indeholder en carport, derfor ...
public class OrderMapper {
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public int insertOrder(Order order, int deliveryInfoId) throws UserException {

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
                    " `totalprice`)" +
                    " VALUES (?,?,?,?,?,?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, deliveryInfoId);
                ps.setInt(2, order.getCarport().getCarportWidth());
                ps.setInt(3,  order.getCarport().getCarportLength());
                ps.setString(4, order.getCarport().getRoof());
                ps.setInt(5, 0);//carport.getShedWidth());
                ps.setInt(6, 0);//getShedLength);
                ps.setTimestamp(7,order.getDate());
                ps.setString(8,order.getStatus());
                ps.setDouble(9, order.getTotalprice());


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

    public List<Order> getOrdersByDeliveryInfoId(List<Integer> deliveryInfoIdList, int deliveryInfoId) throws UserException {
        List<Order> orderListById = new ArrayList<>();
        int arrayLength = deliveryInfoIdList.size();
        try (Connection connection = database.connect()) {

                String sql = "SELECT * FROM order where delivery_info_id = " + deliveryInfoId + ";";

                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        int orderID = rs.getInt("order_id");
                        //int deliveryInfoId = rs.getInt("delivery_info_id");
                        int cpWidth = rs.getInt("cp_width");
                        int cpLength = rs.getInt("cp_length");
                        String cpRoofType = rs.getString("cp_roof_type");
                        int shedWidth = rs.getInt("shed_width");
                        int shedLength = rs.getInt("shed_length");
                        Timestamp date = rs.getTimestamp("date");
                        String status = rs.getString("status");
                        double totalPrice = rs.getDouble("totalprice");


//TODO: Execute methods to add:
                    }

                    return orderListById;

                } catch (SQLException ex) {
                    throw new UserException(ex.getMessage());
                }

            } catch(SQLException | UserException ex){
                throw new UserException("Connection to database could not be established");
            }

        }
    public List<Order> getAllOrdersByStatus(String dbStatus) throws UserException {
        List<Order> orderListByStatus = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM order where status = " + dbStatus + ";";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("order_id");
                    int deliveryInfoId = rs.getInt("delivery_info_id");
                    int cpWidth = rs.getInt("cp_width");
                    int cpLength = rs.getInt("cp_length");
                    String cpRoofType = rs.getString("cp_roof_type");
                    int shedWidth = rs.getInt("shed_width");
                    int shedLength = rs.getInt("shed_length");
                    Timestamp date = rs.getTimestamp("date");
                    String status = rs.getString("status");
                    double totalPrice = rs.getDouble("totalprice");

                    Shed shed = new Shed(shedLength,shedWidth);
                    Carport carport = new Carport(cpWidth,cpLength,cpRoofType, shed);
                    Order order = new Order(orderID,deliveryInfoId,carport,date,status,totalPrice);
                    orderListByStatus.add(order);


//TODO: Execute methods to add:
                }

                return orderListByStatus;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch(SQLException | UserException ex){
            throw new UserException("Connection to database could not be established");
        }

    }

    public List<Order> getAllOrders() throws UserException {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM orders;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("order_id");
                    int deliveryInfoId = rs.getInt("delivery_info_id");
                    int cpWidth = rs.getInt("cp_width");
                    int cpLength = rs.getInt("cp_length");
                    String cpRoofType = rs.getString("cp_roof_type");
                    int shedWidth = rs.getInt("shed_width");
                    int shedLength = rs.getInt("shed_length");
                    Timestamp date = rs.getTimestamp("date");
                    String status = rs.getString("status");
                    double totalPrice = rs.getDouble("totalprice");

                    Shed shed = new Shed(shedLength,shedWidth);
                    Carport carport = new Carport(cpWidth,cpLength,cpRoofType, shed);
                    Order order = new Order(orderID,deliveryInfoId,carport,date,status,totalPrice);
                    orderList.add(order);


//TODO: Execute methods to add:
                }

                return orderList;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch(SQLException | UserException ex){
            throw new UserException(ex.getMessage());

        }

    }

}
