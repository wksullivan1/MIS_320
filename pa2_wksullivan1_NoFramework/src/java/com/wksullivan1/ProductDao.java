/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wksullivan1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willk
 */
public class CustomerDao
{

    private Connection connection;

    public CustomerDao()
    {
        connection = DbConnectionUtil.getConnection();
    }

    public void addCustomer(Customer customer)
    {
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO customernobs (Username,password,Customer_Pref,Payment,Email) VALUES(?,?,?,?,?)");

            st.setString(1, customer.getUsername());
            st.setString(2, customer.getPassword());
            st.setString(3, customer.getCustomer_Pref());
            st.setString(4, customer.getPayment());
            st.setString(5, customer.getEmail());
           
            st.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int Customer_Id)
    {
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM customernobs WHERE Customer_Id= ?");
            st.setInt(1, Customer_Id);
            st.executeUpdate();
        } catch (SQLException ex)
        {
            System.out.println("SQL statement is not executed!" + ex);
        }
    }

    public void updateCustomer(Customer customer)
    {
        try
        {
            PreparedStatement st = connection.prepareStatement("update customernobs set Username=?, Password=?, Customer_Pref=?, Payment=?,  Email=?" + "where Customer_Id=?");

            st.setString(1, customer.getUsername());
            st.setString(2, customer.getPassword());
            st.setString(3, customer.getCustomer_Pref());
            st.setString(4, customer.getPayment());
            st.setString(5, customer.getEmail());           
            st.setInt(6, customer.getCustomer_Id());

            st.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<Customer>();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from customernobs");
            while (rs.next())
            {
                Customer customer = new Customer();
                customer.setCustomer_Id(rs.getInt("Customer_Id"));
                customer.setUsername(rs.getString("Username"));
                customer.setPassword(rs.getString("Password"));
                customer.setCustomer_Pref(rs.getString("Customer_Pref"));
                customer.setPayment(rs.getString("Payment"));
                customer.setEmail(rs.getString("Email"));

                customers.add(customer);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return customers;
    }

    public Customer getCustomerByC(int orderNumber)
    {
        Product product = new Product();
        try
        {
            PreparedStatement ps = connection.prepareStatement("select * from PRODUCT where ORDER_NUM=?");
            ps.setInt(1, orderNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                product.setOrderNumber(rs.getInt("ORDER_NUM"));
                product.setCustomerID(rs.getInt("CUSTOMER_ID"));
                product.setProduct_ID(rs.getInt("PRODUCT_ID"));
                product.setQuantity(rs.getInt("QUANTITY"));
                product.setShippingCost(rs.getInt("SHIPPING_COST"));
                product.setSalesDate(rs.getDate("SALES_DATE"));
                product.setShippingDate(rs.getDate("SHIPPING_DATE"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return product;
    }
}
