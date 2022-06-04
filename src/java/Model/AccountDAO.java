/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import Entity.Account;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class AccountDAO extends ConnectDB {
    public Account getAccount(String user,String pass) {
        String sql = "select * from Account where username="+"'"+user+"'"+" and password="+"'"+pass+"'";
        Account a=null;
        try {

            ResultSet rs = getData(sql);
//            ResultSet rs=getData(sql);
            while (rs.next()) {
                String use2=rs.getString(1);
                String pass2=rs.getString(2);
                int role=rs.getInt(3);
                a=new Account(user, pass2, role);
            }
             } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }
     public int ChangePassword(String usename,String pass) {
        String sql = "UPDATE Account\n" +
           "SET password = ?\n" +
               "WHERE username = ?";
        int n=0;
               
        try {
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setString(1, pass);
            pre.setString(2, usename); 
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public static void main(String[] args) {
        AccountDAO dao=new AccountDAO();
             Date date=new Date();
         SimpleDateFormat sdf2 = new SimpleDateFormat("ss");
       String q=sdf2.format(date);
       int x1 = Integer.parseInt(q);
       System.out.println(q);
       while(true){
             Date date2=new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("ss");
       String a=sdf.format(date2);
//        System.out.println(a);
        int x = Integer.parseInt(a);
        if(x1<30){
            int b=x1+30;
            if(x==b){
                System.out.println("da xoa random");
                break;
            }
        }else{
            int c=x1-30;
            if(x==c){
                
                System.out.println("da xoa random");
                break;
            }
        }
       }
//        Account a=dao.getAccount("use1", "12345678");
//        System.out.println(a);
    }
}
