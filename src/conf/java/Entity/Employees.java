/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Employees {
    int employeeID;
   
    String employeeName; 
	int gender;
	String phone;
	Date dob; 
	String img;
	String username;
        String Email;

    public Employees() {
    }

    public Employees(int employeeID, String employeeName, int gender, String phone, Date dob, String img, String username, String Email) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.gender = gender;
        this.phone = phone;
        this.dob = dob;
        this.img = img;
        this.username = username;
        this.Email = Email;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Employees{" + "employeeID=" + employeeID + ", employeeName=" + employeeName + ", gender=" + gender + ", phone=" + phone + ", dob=" + dob + ", img=" + img + ", username=" + username + ", Email=" + Email + '}';
    }

}