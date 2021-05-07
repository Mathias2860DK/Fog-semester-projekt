package business.entities;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int deliveryInfoId;
    private Carport carport;
    private Timestamp date;
    private String status;
    private double totalprice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDeliveryInfoId() {
        return deliveryInfoId;
    }

    public void setDeliveryInfoId(int deliveryInfoId) {
        this.deliveryInfoId = deliveryInfoId;
    }

    public Carport getCarport() {
        return carport;
    }

    public void setCarport(Carport carport) {
        this.carport = carport;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Order(int orderId, int deliveryInfoId, Carport carport, Timestamp date, String status, double totalprice) {
        this.orderId = orderId;
        this.deliveryInfoId = deliveryInfoId;
        this.carport = carport;
        this.date = date;
        this.status = status;
        this.totalprice = totalprice;
    }

    public Order(int deliveryInfoId, Carport carport, Timestamp date, String status, double totalprice) {
        this.deliveryInfoId = deliveryInfoId;
        this.carport = carport;
        this.date = date;
        this.status = status;
        this.totalprice = totalprice;
    }
}
