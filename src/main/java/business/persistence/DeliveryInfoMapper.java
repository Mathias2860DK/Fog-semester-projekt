package business.persistence;

import business.entities.DeliveryInfo;
import business.entities.Order;
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

            String sql = "INSERT INTO `delivery_info`" + " (`user_id`," + " `name`, " + " `adress`, " +
                    " `zipcode_city`, " +
                    " `phone`, " + " `email`, " + "`remarks`)" +
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

    public int deleteDeliveryInfo(int deliveryInfoId) throws UserException {
        try (Connection connection = database.connect()) {

            String sql = "DELETE FROM delivery_info WHERE delivery_info_id = " + deliveryInfoId + ";";

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

    public List<DeliveryInfo> getAllDeliveryInfo() throws UserException {
        List<DeliveryInfo> customerList = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM delivery_info;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int deliveryInfoId = rs.getInt("delivery_info_id");
                    int userId = rs.getInt("user_id");
                    String navn = rs.getString("name");
                    String adresse = rs.getString("adress");
                    String zip = rs.getString("zipcode_city");
                    int telefon = rs.getInt("phone");
                    String email = rs.getString("email");
                    String remark = rs.getString("remarks");


                    DeliveryInfo deliveryInfos = new DeliveryInfo(deliveryInfoId, userId, navn, adresse, zip, telefon, email, remark);

                    customerList.add(deliveryInfos);
                }
                return customerList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }


    public List<DeliveryInfo> getAllCustomers() throws UserException {
        List<DeliveryInfo> customerList = new ArrayList<>();
        List<DeliveryInfo> customerModi = new ArrayList<>();
        List<Integer> listOfID = new ArrayList<>();
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
                    if (deliveryInfos.getUserId() != 1) {
                        customerModi.add(deliveryInfos);
                        for (DeliveryInfo thisDelInfo:customerModi) {
                            if(!listOfID.contains(thisDelInfo.getUserId())){
                                listOfID.add(deliveryInfos.getUserId());
                                customerList.add(thisDelInfo);
                            }
                        }
                    }
                   /* for (DeliveryInfo deliveryInfo: customerModi) {
                        if (!customerList.contains(deliveryInfo.getUserId())){
                            customerList.add(deliveryInfo);
                        }
                    }*/
                }
                return customerList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public String getCustomerEmail(int deliveryId) throws UserException {
        String email = null;
        for (DeliveryInfo deliveryInfo : getAllDeliveryInfo()) {
            if (deliveryId == deliveryInfo.getDeliveryInfoId()) {
                email = deliveryInfo.getEmail();
            }
        }
        return email;
    }

    public DeliveryInfo getLatestDeliveryInfoByUserId(int userId) throws UserException {
        DeliveryInfo deliveryInfo = null;
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM delivery_info where user_id = " + userId + " order by delivery_info_id desc limit 1;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int deliveryInfoId = rs.getInt("delivery_info_id");
                    String navn = rs.getString("name");
                    String adresse = rs.getString("adress");
                    String zip = rs.getString("zipcode_city");
                    int phone = rs.getInt("phone");
                    String email = rs.getString("email");


                    deliveryInfo = new DeliveryInfo(deliveryInfoId, userId, navn, adresse, zip, phone, email, "");//remarks should not be retrieved again.
                }
                return deliveryInfo;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
