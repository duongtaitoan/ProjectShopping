/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Define.DateUitils;
import Entity.OrderDTO;
import Entity.OrderDetailsDTO;
import Uitilis.DBUitils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author duong
 */
public class OrderDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public ArrayList<OrderDTO> getOrderHistory(String user, String fromDate, String toDate, String productName) throws Exception {
        ArrayList<OrderDTO> listOrder = new ArrayList<>();
        String sql = "SELECT o.order_id, o.user_id, o.total_price, o.order_date, p.product_name,"
                + " od.order_details_id, od.product_id, od.quantity, od.unit_price, od.status, p.product_id"
                + " FROM tblOrder o"
                + " INNER JOIN tblOrderDetails od on o.order_id = od.order_id"
                + " INNER JOIN tblProduct p on od.product_id = p.product_id"
                + " INNER JOIN tblUser u on u.user_id = o.user_id"
                + " WHERE u.email = ?"
                + " AND od.status = ?";

        if (fromDate != null && !fromDate.equals("")) {
            sql += " AND o.order_date >= '" + fromDate + "'";
        }
        if (toDate != null && !toDate.equals("")) {
            sql += " AND o.order_date <= '" + toDate + "'";
        }
        if (productName != null || !productName.equals("")) {
            sql += " AND p.product_name LIKE '%" + productName + "%'";
        }
        sql += " ORDER BY o.order_id DESC";
        try {
            conn = DBUitils.implementConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user);
            preStm.setBoolean(2, true);
            rs = preStm.executeQuery();

            int currentBookingID = 0;
            int currentIndex = -1;
            ArrayList<OrderDetailsDTO> listOrderDetail = new ArrayList<>();
            while (rs.next()) {

                int orderId = rs.getInt("order_id");
                float totalPrice = rs.getFloat("total_price");
                String orderDate = rs.getDate("order_date").toString();
                int userId = rs.getInt("user_id");

                OrderDetailsDTO orderDetail = new OrderDetailsDTO();
                orderDetail.setOrderDetailsId(rs.getInt("order_details_id"));
                orderDetail.setOrderId(orderId);
                orderDetail.setProductId(rs.getInt("product_id"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setStatus(rs.getBoolean("status"));
                orderDetail.setUnitPrice(rs.getFloat("unit_price"));
                orderDetail.setProductName(rs.getString("product_name"));

                if (currentBookingID == 0 || currentBookingID != orderId) {
                    currentBookingID = orderId;

                    OrderDTO order = new OrderDTO();
                    order.setOrderId(orderId);
                    order.setUserId(userId);
                    order.setTotalPrice(totalPrice);
                    order.setOrderDate(orderDate);

                    listOrderDetail = new ArrayList<>();
                    listOrderDetail.add(orderDetail);

                    order.setOrderDetails(listOrderDetail);

                    listOrder.add(order);
                    currentIndex += 1;
                } else if (currentBookingID != 0 && currentBookingID == orderId) {
                    listOrderDetail.add(orderDetail);
                    listOrder.get(currentIndex).setOrderDetails(listOrderDetail);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return listOrder;
    }

    public Integer insertOrder(OrderDTO orderDTO) throws Exception {
        DateUitils dateUtils = new DateUitils();
        int idOrder = 0;
        String sql = "INSERT INTO tblOrder(user_id, order_date, total_price)"
                + " OUTPUT inserted.order_id values(?,?,?)";
        try {
            conn = DBUitils.implementConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, orderDTO.getUserId());
            preStm.setTimestamp(2, java.sql.Timestamp.valueOf(dateUtils.getCurrentDate()));
            preStm.setFloat(3, orderDTO.getTotalPrice());
            rs = preStm.executeQuery();
            if (rs.next()) {
                idOrder = rs.getInt("order_id");
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return idOrder;
    }

}
