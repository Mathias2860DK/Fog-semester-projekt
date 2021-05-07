package business.entities;

public class DeliveryInfo {
   private int deliveryInfoId;
   private int userId; //UU-id
   private String name;
   private String address;
   private String zipCodeCity;
   private int phone;
   private String email;
   private String remarks;

    public DeliveryInfo(int userId, String name, String address, String zipCodeCity, int phone, String email, String remarks) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.zipCodeCity = zipCodeCity;
        this.phone = phone;
        this.email = email;
        this.remarks = remarks;
    }

    public DeliveryInfo(int deliveryInfoId, int userId, String name, String address, String zipCodeCity, int phone, String email, String remarks) {
        this.deliveryInfoId = deliveryInfoId;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.zipCodeCity = zipCodeCity;
        this.phone = phone;
        this.email = email;
        this.remarks = remarks;
    }

    public int getDeliveryInfoId() {
        return deliveryInfoId;
    }

    public void setDeliveryInfoId(int deliveryInfoId) {
        this.deliveryInfoId = deliveryInfoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCodeCity() {
        return zipCodeCity;
    }

    public void setZipCodeCity(String zipCodeCity) {
        this.zipCodeCity = zipCodeCity;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
