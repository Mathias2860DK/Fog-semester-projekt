package business.persistence;

import business.entities.Carport;
import business.entities.DeliveryInfo;
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
                ps.setInt(3, order.getCarport().getCarportLength());
                ps.setString(4, order.getCarport().getRoof());
                if(order.getCarport().getShed()== null) {
                    ps.setInt(5, 0);//carport.getShedWidth());
                    ps.setInt(6, 0);//getShedLength);
                } else {
                    ps.setInt(5, order.getCarport().getShed().getShedWidth());
                    ps.setInt(6, order.getCarport().getShed().getShedLength());
                }
                ps.setTimestamp(7, order.getDate());
                ps.setString(8, order.getStatus());
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

    public Order getOrdersByDeliveryInfoId(int deliveryInfoId) throws UserException {
        Order order = null;
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM orders where delivery_info_id = " + deliveryInfoId + ";";

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

                    Shed shed = new Shed(shedLength);
                    Carport carport = new Carport(cpWidth, cpLength, cpRoofType, shed);
                    order = new Order(orderID, deliveryInfoId, carport, date, status, totalPrice);

                }

                return order;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());

        }

    }

    public List<Order> getAllOrdersByStatus(String dbStatus) throws UserException {
        List<Order> orderListByStatus = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM orders where status = " + dbStatus + ";";

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

                    Shed shed = new Shed(shedLength);
                    Carport carport = new Carport(cpWidth, cpLength, cpRoofType, shed);
                    Order order = new Order(orderID, deliveryInfoId, carport, date, status, totalPrice);
                    orderListByStatus.add(order);


//TODO: Execute methods to add:
                }

                return orderListByStatus;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException | UserException ex) {
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

                    Shed shed = new Shed(shedLength);
                    Carport carport = new Carport(cpWidth, cpLength, cpRoofType, shed);
                    Order order = new Order(orderID, deliveryInfoId, carport, date, status, totalPrice);
                    orderList.add(order);


//TODO: Execute methods to add:
                }

                return orderList;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());

        }

    }

    public int deleteOrder(int orderId) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "DELETE FROM orders WHERE order_id = " + orderId + ";";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                int rowsAffected = ps.executeUpdate();
                return rowsAffected;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public Order getOrderById(int orderId) throws UserException {
        Order order = null;
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM orders WHERE order_id = " + orderId + ";";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("order_id");
                    int deliveryInfoId = rs.getInt("delivery_info_id");
                    int cpWidth = rs.getInt("cp_width");
                    int cpLength = rs.getInt("cp_length");
                    String cpRoofType = rs.getString("cp_roof_type");
                    int shedLength = rs.getInt("shed_length");
                    Timestamp date = rs.getTimestamp("date");
                    String status = rs.getString("status");
                    double totalPrice = rs.getDouble("totalprice");


                    Shed shed = new Shed(cpWidth);
                    shed.setShedLength(shedLength);
                    Carport carport = new Carport(cpWidth, cpLength, cpRoofType, shed);
                    order = new Order(orderID, deliveryInfoId, carport, date, status, totalPrice);

//TODO: Execute methods to add:
                }

                return order;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());

        }

    }

    public int updateStatusAndPrice(int orderId, String status, double totalPrice) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "UPDATE orders SET status = '" + status + "', totalprice = '" + totalPrice +
                    "' WHERE (order_id = '" + orderId + "')";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                int rowsAffected = ps.executeUpdate();
                return rowsAffected;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public int updateStatus(int orderId, String status) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "UPDATE orders SET status = '" + status + "'" +
                    " WHERE (order_id = '" + orderId + "')";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                int rowsAffected = ps.executeUpdate();
                return rowsAffected;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

}

