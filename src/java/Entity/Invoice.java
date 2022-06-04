/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;





/**
 *
 * @author SmileMint
 */
public class Invoice {
    private int invoiceID;
    private String createdDate;
    private int employeeID;
    private int customerID;

    public Invoice() {
    }

    public Invoice(int invoiceID, String createdDate, int employeeID, int customerID) {
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
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

    @Override
    public String toString() {
        return "Invoice{" + "invoiceID=" + invoiceID + ", createdDate=" + createdDate + ", employeeID=" + employeeID + ", customerID=" + customerID + '}';
    }

   
    
    
}