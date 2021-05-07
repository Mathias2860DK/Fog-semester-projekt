package business.services;

import business.entities.DeliveryInfo;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.DeliveryInfoMapper;

public class DeliveryInfoFacade {
        DeliveryInfoMapper deliveryInfoMapper;

        public DeliveryInfoFacade(Database database) {
            deliveryInfoMapper = new DeliveryInfoMapper(database);
        }
    public int insertDeliveryInfo(DeliveryInfo deliveryInfo) throws UserException {
            return deliveryInfoMapper.insertDeliveryInfo(deliveryInfo);
    }
}
