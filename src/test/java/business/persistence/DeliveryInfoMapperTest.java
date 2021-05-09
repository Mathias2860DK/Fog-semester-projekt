package business.persistence;

import business.entities.DeliveryInfo;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryInfoMapperTest {
    private final static String DATABASE = "fog";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "root";
    private final static String PASSWORD = "Vinter2020";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static DeliveryInfoMapper deliveryInfoMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            deliveryInfoMapper = new DeliveryInfoMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("drop table if exists delivery_info");
            stmt.execute("drop table if exists users" );
            stmt.execute("create table " + TESTDATABASE + ".users LIKE " + DATABASE + ".users;" );
            stmt.execute("create table " + TESTDATABASE + ".delivery_info LIKE " + DATABASE + ".delivery_info;" );
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
    void insertDeliveryInfo() throws UserException {
        //Cheks if the insertDeliveryInfo method returns the expected id.
        //Insert the deliveryInfo object and inserts it in the method.
        DeliveryInfo deliveryInfo = new DeliveryInfo(1,"Jens","Jagtvej 18","Søborg 2860",12234563,"jens@gmail.com","giver maks 10.000kr for denne carport");
        int deliveryInfoId = deliveryInfoMapper.insertDeliveryInfo(deliveryInfo);
        assertEquals(2,deliveryInfoId);
    }

}