package com.kcp.oms.order.rabbitmq;

/**
 * 
 * @author kapanda
 *
 */
public class ShippingMessage {
    private String address;
    private String location;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
