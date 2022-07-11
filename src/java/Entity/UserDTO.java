/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String userId;
    private String email;
    private String password;
    private int role_id;
    private boolean status;
    private String full_name;
    private int phone;
    private String create_date;

    private String role_name;
    public UserDTO() {
    }

    public UserDTO(String userId, String email, String password, int role_id, boolean status, String full_name, int phone, String create_date, String role_name) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
        this.status = status;
        this.full_name = full_name;
        this.phone = phone;
        this.create_date = create_date;
        this.role_name = role_name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    
    @Override
    public String toString() {
        return "UserDTO{" + "userId=" + userId + ", email=" + email + ", password=" + password + ", role_id=" + role_id + ", status=" + status + ", full_name=" + full_name + ", phone=" + phone + ", create_date=" + create_date + '}';
    }

}
