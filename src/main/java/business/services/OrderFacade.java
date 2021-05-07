package business.services;

import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.sql.Timestamp;

public class OrderFacade {
    OrderMapper orderMapper;

    public OrderFacade(Database database) {
        orderMapper = new OrderMapper(database);
    }
    public int insertOrder(int deliveryInfoId, int carportWidth, int carportLength, String roof, int shedWidth, int shedLength, Timestamp date, String status, double totalPrice, int roofPitch) throws UserException {
return orderMapper.insertOrder( deliveryInfoId,carportWidth, carportLength, roof, shedWidth, shedLength, date, status, totalPrice, roofPitch);
    }
    }
