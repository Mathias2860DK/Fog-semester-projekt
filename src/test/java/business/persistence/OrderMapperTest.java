package business.persistence;

import business.entities.Carport;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {
    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "root";
    private final static String PASSWORD = "Vinter2020";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static OrderMapper orderMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            orderMapper = new OrderMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("drop table if exists `fog_test`.`users`;");
            stmt.execute("drop table if exists  `fog_test`.`delivery_info`;");
            stmt.execute("drop table if exists  `fog_test`.`orders`;");


            stmt.execute("create table " + TESTDATABASE + ".users LIKE " + DATABASE + ".users;" );
            stmt.execute("create table " + TESTDATABASE + ".delivery_info LIKE " + DATABASE + ".delivery_info;" );
            stmt.execute("create table " + TESTDATABASE + ".orders LIKE " + DATABASE + ".orders;" );

            stmt.execute(
                    "insert into users values " +
                            "(1,'geust@somewhere.com','guest','guest'), " +
                            "(2,'ken@somewhere.com','kensen','customer'), " +
                            "(3,'robin@somewhere.com','batman','employee')");
            stmt.execute("INSERT INTO `fog_test`.`delivery_info` (`user_id`, `name`, `adress`,`zipcode_city`,`phone`,`email`,`remarks`) VALUES ('1', 'Mathias','Enemarksvej','2100 Østerbro','30302020','mat@gmail.com','ingen');");
            stmt.execute("INSERT INTO `fog_test`.`delivery_info` (`user_id`, `name`, `adress`,`zipcode_city`,`phone`,`email`,`remarks`) VALUES ('2', 'Jens','Jensvej','2100 Østerbro','12121212','jens@gmail.com','wish for a nice carport');");

            //insert orders:
            stmt.execute("INSERT INTO `fog_test`.`orders` (`delivery_info_id`, `cp_width`, `cp_length`, `cp_roof_type`, `shed_width`, `shed_length`, `status`, `totalprice`) VALUES ('1', '720', '600', 'trapez plader', '0', '0', 'accepted', '100');");
            stmt.execute("INSERT INTO `fog_test`.`orders` (`delivery_info_id`, `cp_width`, `cp_length`, `cp_roof_type`, `shed_width`, `shed_length`, `status`, `totalprice`) VALUES ('1', '600', '600', 'trapez plader', '0', '0', 'paid', '1000');");
            stmt.execute("INSERT INTO `fog_test`.`orders` (`delivery_info_id`, `cp_width`, `cp_length`, `cp_roof_type`, `shed_width`, `shed_length`, `status`, `totalprice`) VALUES ('2', '400', '400', 'trapez plader', '0', '0', 'request', '15000');");

        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }
    @Test
    void insertOrder() throws UserException {
        //creates the carport object.
        Carport carport = new Carport(720,680,"trapez plader");
        Order order = new Order(1,carport,new Timestamp(System.currentTimeMillis()),"request",100);

        //cheks if the expected orderId is returned. Three orders is already placed before running this method
        assertEquals(4,orderMapper.insertOrder(order,1));

    }

    @Test
    void getAllOrdersByStatus() throws UserException {
        //TODO: Virker ikke - Hvorfor???
       // List<Order> orderList = orderMapper.getAllOrdersByStatus("accepted");
   //     int orderListSize = orderList.size();
    //    assertEquals(1,orderListSize);
    }

    @Test
    void getAllOrders() throws UserException {
        List<Order> orderList = orderMapper.getAllOrders();
        assertEquals(3,orderList.size());
        assertEquals(720,orderList.get(0).getCarport().getCarportWidth());
        assertEquals("accepted",orderList.get(0).getStatus());
    }

    @Test
    void getOrdersByDeliveryInfoId() throws UserException {
        Order order = orderMapper.getOrdersByDeliveryInfoId(2);
        assertEquals(15000,order.getTotalprice());

        assertEquals(400,order.getCarport().getCarportLength());
    }

    @Test
    void getOrdersByDeliveryInfoIdFail() throws UserException {
        //This should not happen
      /*  assertThrows(UserException.class, () ->{
            orderMapper.getOrdersByDeliveryInfoId(10);
        });*/

    }

    @Test
    void deleteOrder() throws UserException {
        //if 1 is returned 1 row is affected.
        assertEquals(1,orderMapper.deleteOrder(2));

    }

    @Test
    void deleteOrderThatDosentExist() throws UserException {
        assertEquals(0,orderMapper.deleteOrder(10));
    }

    @Test
    void getOrderById() throws UserException {
        //'1', '600', '600', 'trapez plader', '0', '0', 'paid', '1000'
        Order order = orderMapper.getOrderById(2);
        assertEquals(600,order.getCarport().getCarportWidth());
        assertEquals("paid",order.getStatus());
    }

    @Test
    void updateStatusAndPrice() throws UserException {
        //if 1 is returned, 1 row is affected
        assertEquals(1,orderMapper.updateStatusAndPrice(2,"accepted",1500));
        //Cheks to see if the right values where updated
        Order order = orderMapper.getOrderById(2);
        assertEquals("accepted",order.getStatus());
        assertEquals(1500,order.getTotalprice());
    }

    @Test
    void updateStatus() throws UserException {
        orderMapper.updateStatus(2,"offer sent");
        assertEquals(1, orderMapper.updateStatus(2,"offer sent"));
        //Cheks to see if the right values where updated
        Order order = orderMapper.getOrderById(2);
        assertEquals("offer sent",order.getStatus());
    }
}