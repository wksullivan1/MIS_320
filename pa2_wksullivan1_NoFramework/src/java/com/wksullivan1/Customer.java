/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wksullivan1;

/**
 *
 * @author wsullivan16
 */
public class Customer {
    
    private int Customer_Id;
    private String Username;
    private String Password;
    private String Customer_Pref;
    private String Payment;
    private String Email;

    public int getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(int Customer_Id) {
        this.Customer_Id = Customer_Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCustomer_Pref() {
        return Customer_Pref;
    }

    public void setCustomer_Pref(String Customer_Pref) {
        this.Customer_Pref = Customer_Pref;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String Payment) {
        this.Payment = Payment;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
