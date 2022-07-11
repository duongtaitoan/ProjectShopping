/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author duong
 */
public class OrderDTO implements Serializable{
    private int orderId;
    private int userId;
    private float totalPrice;
    private String orderDate;
    ArrayList<OrderDetailsDTO> orderDetails;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, int userId, float totalPrice, String orderDate, ArrayList<OrderDetailsDTO> orderDetails) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public ArrayList<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderId=" + orderId + ", userId=" + userId + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", orderDetails=" + orderDetails + '}';
    }
    
}
