package business.persistence;

import business.entities.Carport;
import business.entities.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

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
            stmt.execute("drop table if exists delivery_info");
            stmt.execute("drop table if exists users");
            stmt.execute("drop table if exists order");
            stmt.execute("create table " + TESTDATABASE + ".users LIKE " + DATABASE + ".users;" );
            stmt.execute("create table " + TESTDATABASE + ".delivery_info LIKE " + DATABASE + ".delivery_info;" );
            stmt.execute("create table " + TESTDATABASE + ".order LIKE " + DATABASE + ".order;" );
            stmt.execute(
                    "insert into users values " +
                            "(1,'geust@somewhere.com','guest','guest'), " +
                            "(2,'ken@somewhere.com','kensen','customer'), " +
                            "(3,'robin@somewhere.com','batman','employee')");
            stmt.execute("INSERT INTO `fog_test`.`delivery_info` (`user_id`, `name`, `adress`,`zipcode_city`,`phone`,`email`,`remarks`) VALUES ('1', 'Mathias','Enemarksvej','2100 Østerbro','30302020','mat@gmail.com','ingen');");

        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }
    @Test
    void insertOrder() { //denne metode vil fejle, når vi laver det endelige carport objekt.
        //creates the carport object.
        Carport carport = new Carport(720,680,"Betontagsten - Rød",15);
        Order order = new Order(1,carport,new Timestamp(System.currentTimeMillis()),"request",100);
        //orderMapper.insertOrder(carport,)

        //insertOrder skal updateres. lige nu skal metoden både have en order og en garage. Men der er
        //blevet lavet en constructor, der tager imod en garage, så metode signaturen skal updateres.
    }
}