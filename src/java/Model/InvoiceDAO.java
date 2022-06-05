package Model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entity.Cart;
import Entity.Invoice;

public class InvoiceDAO extends ConnectDB {

    PreparedStatement stm = null;
    ResultSet rs = null;

    public ArrayList<Invoice> getListInvoiceByEmployeeID(int employeeID) {
        ArrayList<Invoice> list = new ArrayList<>();
        String sql = "SELECT * FROM Invoice WHERE employeeID = " + employeeID;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int invoiceID = rs.getInt("invoiceID");
                Date createdDate = rs.getDate("createdDate");
                int customerID = rs.getInt("customerID");
                list.add(new Invoice(invoiceID, createdDate, employeeID, customerID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void addInvoice(int invoiceID, int customerID, int employeeID, ArrayList<Cart> cart) {
        String addInvoiceQuery = "INSERT INTO [dbo].[Invoice]\n"
                + "           ([invoiceID]\n"
                + "           ,[createdDate]\n"
                + "           ,[employeeID]\n"
                + "           ,[customerID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        Date createdDate = new Date(System.currentTimeMillis());
        try {
            stm = conn.prepareStatement(addInvoiceQuery);
            stm.setString(1, String.valueOf(invoiceID));
            stm.setString(2, String.valueOf(createdDate));
            stm.setString(3, String.valueOf(employeeID));
            stm.setString(4, String.valueOf(customerID));
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String addDetailInvoiceQuery = "INSERT INTO [dbo].[Product_Invoice]\n"
                    + "           ([quantity]\n"
                    + "           ,[invoiceID]\n"
                    + "           ,[productID])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            for (Cart c : cart) {
                stm = conn.prepareStatement(addDetailInvoiceQuery);
                stm.setString(1, String.valueOf(c.getQuantity()));
                stm.setString(2, String.valueOf(invoiceID));
                stm.setString(3, String.valueOf(c.getProductID()));
                stm.executeUpdate();
                stm.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Cart> getCartOfInvoice(int invoiceID) {
        ArrayList<Cart> cart = new ArrayList<>();
        String sql = "SELECT a.productID, b.productName, a.quantity "
                + "FROM Product_Invoice AS a LEFT JOIN Product AS b "
                + "ON a.productID = b.productID"
                + "WHERE a.invoiceID =  " + invoiceID;
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                cart.add(new Cart(productID, productName, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cart;
    }

    public ArrayList<Invoice> searchInvoice(int invoiceID) {
        String sql = "SELECT * FROM Invoice WHERE invoiceID like '%" + invoiceID + "%'";
        ArrayList<Invoice> list = new ArrayList();
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("invoiceID");
                Date createdDate = rs.getDate("createdDate");
                int employeeID = rs.getInt("employeeID");
                int customerID = rs.getInt("customerID");
                list.add(new Invoice(id, createdDate, employeeID, customerID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Invoice> searchInvoice(Date createdDate) {
        String sql = "SELECT * FROM Invoice WHERE createdDate = " + createdDate;
        ArrayList<Invoice> list = new ArrayList();
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int invoiceID = rs.getInt("invoiceID");
                int employeeID = rs.getInt("employeeID");
                int customerID = rs.getInt("customerID");
                list.add(new Invoice(invoiceID, createdDate, employeeID, customerID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Invoice> searchInvoice(String customerName) {
        String sql = "SELECT i.invoiceID, i.createdDate, i.employeeID,c.customerID,c.customerName "
                + "FROM Invoice as i LEFT JOIN Customer as c "
                + "ON i.customerID = c.customerID "
                + "WHERE customerName like '%" + customerName + "%'";
        ArrayList<Invoice> list = new ArrayList();
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("invoiceID");
                Date createdDate = rs.getDate("createdDate");
                int employeeID = rs.getInt("employeeID");
                int customerID = rs.getInt("customerID");
                list.add(new Invoice(id, createdDate, employeeID, customerID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
