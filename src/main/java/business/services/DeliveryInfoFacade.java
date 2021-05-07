package business.services;

import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.DeliveryInfoMapper;

public class DeliveryInfoFacade {
        DeliveryInfoMapper deliveryInfoMapper;

        public DeliveryInfoFacade(Database database) {
            deliveryInfoMapper = new DeliveryInfoMapper(database);
        }
    public int insertDeliveryInfo(int userId, String name, String address, String zipCodeCity, int phone, String email, String remarks) throws UserException {
            return deliveryInfoMapper.insertDeliveryInfo(userId,name,address,zipCodeCity,phone,email,remarks);
    }
}
