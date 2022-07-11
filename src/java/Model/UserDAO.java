/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.UserDTO;
import Uitilis.DBUitils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO implements Serializable {

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

    public UserDTO getRole(UserDTO user) throws Exception {
        UserDTO userDTO = new UserDTO();
        String sql = "SELECT r.role_name, u.email, u.full_name FROM tblUser u"
                + " INNER JOIN tblRole r ON r.role_id = u.role_id"
                + " WHERE email = ? and password = ? and status = ?";
        try {
            conn = DBUitils.implementConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user.getEmail());
            preStm.setString(2, user.getPassword());
            preStm.setBoolean(3, Boolean.TRUE);
            rs = preStm.executeQuery();
            while (rs.next()) {
                userDTO.setRole_name(rs.getString("role_name"));
                userDTO.setEmail(rs.getString("email"));
                userDTO.setFull_name(rs.getString("full_name"));
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return userDTO;
    }

    public int getUserId(String email) throws Exception {
        Integer userID = 0;
        String sql = "SELECT user_id FROM tblUser WHERE email = ? and status = ?";
        try {
            conn = DBUitils.implementConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, email);
            preStm.setBoolean(2, Boolean.TRUE);
            rs = preStm.executeQuery();
            while (rs.next()) {
                userID = rs.getInt("user_id");
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return userID;
    }

}
