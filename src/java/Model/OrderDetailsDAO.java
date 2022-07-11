/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.OrderDetailsDTO;
import Uitilis.DBUitils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author duong
 */
public class OrderDetailsDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public void closeConnection() throws SQLException {
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

    public boolean insertOrderDetail(OrderDetailsDTO orderDetailDTO) throws SQLException {
        boolean isSuccess = false;
        String sql = "INSERT INTO tblOrderDetails (order_id, product_id, quantity, unit_price, status) VALUES(?,?,?,?,?)";
        try {
            conn = DBUitils.implementConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, orderDetailDTO.getOrderId());
            preStm.setInt(2, orderDetailDTO.getProductId());
            preStm.setInt(3, orderDetailDTO.getQuantity());
            preStm.setFloat(4, orderDetailDTO.getUnitPrice());
            preStm.setBoolean(5, Boolean.TRUE);
            if (preStm.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return isSuccess;
    }
}
