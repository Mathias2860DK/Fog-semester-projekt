package business.services;

import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.sql.Timestamp;

public class OrderFacade {
    OrderMapper orderMapper;

    public OrderFacade(Database database) {
        orderMapper = new OrderMapper(database);
    }

    public int insertOrder(Order order, int deliveryInfoId) throws UserException {
        return orderMapper.insertOrder( order, deliveryInfoId);
    }
}
