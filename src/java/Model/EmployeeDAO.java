/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Account;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class EmployeeDAO extends ConnectDB{
    public String getEmail(String user) {
        String sql = "select Email from Employees where username="+"'"+user+"'";
    String email="";
        try {

            ResultSet rs = getData(sql);
//            ResultSet rs=getData(sql);
            while (rs.next()) {
                email=rs.getString(1);
                
            }
             } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return email;
    }
     public static void main(String[] args) {
       EmployeeDAO dao=new EmployeeDAO();
        String a=dao.getEmail("user1");
        System.out.println(a);
    }
}
