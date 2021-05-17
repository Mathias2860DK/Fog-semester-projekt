package business.services;

import business.entities.DeliveryInfo;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.DeliveryInfoMapper;

import java.util.List;

public class DeliveryInfoFacade {
        DeliveryInfoMapper deliveryInfoMapper;

        public DeliveryInfoFacade(Database database) {
            deliveryInfoMapper = new DeliveryInfoMapper(database);
        }
    public int insertDeliveryInfo(DeliveryInfo deliveryInfo) throws UserException {
            return deliveryInfoMapper.insertDeliveryInfo(deliveryInfo);
    }
    public List<Integer> getDeliveryInfoIdByUserId(int userId) throws UserException {
            return deliveryInfoMapper.getDeliveryInfoIdByUserId(userId);
    }
    public List<DeliveryInfo> getAllCustomers() throws UserException {
        return deliveryInfoMapper.getAllCustomers();
    }
}
