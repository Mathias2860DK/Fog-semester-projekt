package business.persistence;

import business.entities.Carport;
import business.entities.DeliveryInfo;
import business.entities.Order;
import business.entities.Shed;
import business.exceptions.UserException;
import business.services.DeliveryInfoFacade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryInfoMapper {
    private Database database;

    public DeliveryInfoMapper(Database database) {
        this.database = database;
    }

    public int insertDeliveryInfo(DeliveryInfo deliveryInfo) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO `delivery_info`" +
                    " (`user_id`," +
                    " `name`, " +
                    " `adress`, " +
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
                //ps.setInt("delivery_info_id",deliveryInfoId);


                return deliveryInfoId;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    //Used to retrieve all DeliveryInfoId's by userId. To later display all orders from that particular user
    public List<Integer> getDeliveryInfoIdByUserId(int userId) throws UserException {
        List<Integer> deliveryInfoIdList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT delivery_info_id FROM delivery_info where user_id = " + userId + ";";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int deliveryInfoId = rs.getInt(1);

                    deliveryInfoIdList.add(deliveryInfoId);

                }
                return deliveryInfoIdList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<DeliveryInfo> getAllCustomers() throws UserException {
        List<DeliveryInfo> customerList = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM delivery_info;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int userId = rs.getInt("user_id");
                    String navn = rs.getString("name");
                    String adresse = rs.getString("adress");
                    String zip = rs.getString("zipcode_city");
                    int telefon = rs.getInt("phone");
                    String email = rs.getString("email");
                    String remark = rs.getString("remarks");


                    DeliveryInfo deliveryInfos = new DeliveryInfo(userId, navn, adresse, zip, telefon, email, remark);
                    customerList.add(deliveryInfos);

                }
                    return customerList;
                } catch(SQLException ex){
                    throw new UserException(ex.getMessage());
                }

            } catch (SQLException | UserException ex) {
                throw new UserException(ex.getMessage());
            }
        }
}
