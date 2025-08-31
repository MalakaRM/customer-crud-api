package com.example.point_of_sale.dto;

public class CustomerUpdateDTO {
    private int customerId;
    private String customerAddress;
    private String contactNumber;
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerId,String customerName,String customerAddress, String contactNumber) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumber = contactNumber;

    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }



    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


}
