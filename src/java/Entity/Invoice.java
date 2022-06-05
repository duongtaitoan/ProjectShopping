
package Entity;

import java.sql.Date;
import java.util.ArrayList;

public class Invoice {
    private int invoiceID;   
    private Date createdDate;
    private int employeeID;
    private int customerID;
    private ArrayList<Cart> cart = new ArrayList<>();
    
    public Invoice() {
        
    }

    public Invoice(int invoiceID, Date createdDate, int employeeID, int customerID) {
        this.invoiceID = invoiceID;
        this.createdDate = createdDate;
        this.employeeID = employeeID;
        this.customerID = customerID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public ArrayList<Cart> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Cart> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceID=" + invoiceID + ", createdDate=" + createdDate + ", employeeID=" + employeeID + ", customerID=" + customerID + ", cart=" + cart + '}';
    }
 
}
