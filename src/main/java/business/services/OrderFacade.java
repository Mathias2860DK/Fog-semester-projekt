package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade {
    OrderMapper orderMapper;

    public OrderFacade(Database database) {
        orderMapper = new OrderMapper(database);
    }

    public int insertOrder(Order order, int deliveryInfoId) throws UserException {
        return orderMapper.insertOrder(order, deliveryInfoId);
    }

    public List<Order> getAllOrdersByStatus(String dbStatus) throws UserException {
        return orderMapper.getAllOrdersByStatus(dbStatus);
    }

    public List<Order> getAllOrders() throws UserException {
        return orderMapper.getAllOrders();
    }

    public Order getOrdersByDeliveryInfoId(int deliveryInfoId) throws UserException {
        return orderMapper.getOrdersByDeliveryInfoId(deliveryInfoId);
    }

    public int deleteOrder(int orderId) throws UserException {
        return orderMapper.deleteOrder(orderId);
    }

    public Order getOrderById(int orderId) throws UserException {
        return orderMapper.getOrderById(orderId);
    }

    public int updateStatusAndPrice(int orderId, String status, double totalPrice) throws UserException {
        return orderMapper.updateStatusAndPrice(orderId, status, totalPrice);
    }

    public int updateStatus(int orderId, String status) throws UserException {
        return orderMapper.updateStatus(orderId, status);
    }
}
