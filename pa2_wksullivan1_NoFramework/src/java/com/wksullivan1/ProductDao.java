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
public class ProductDao
{

    private Connection connection;

    public ProductDao()
    {
        connection = DbConnectionUtil.getConnection();
    }

    public void addProduct(Product product)
    {
        try
        {
            PreparedStatement st = connection.prepareStatement("INSERT INTO PRODUCT(ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST,SALES_DATE,SHIPPING_DATE) VALUES(?,?,?,?,?,?,?)");

            st.setInt(1, product.getOrderNumber());
            st.setInt(2, product.getCustomerID());
            st.setInt(3, product.getProduct_ID());
            st.setInt(4, product.getQuantity());
            st.setInt(5, product.getShippingCost());
            st.setDate(6, new java.sql.Date(product.getSalesDate().getTime()));
            st.setDate(7, new java.sql.Date(product.getShippingDate().getTime()));
            st.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int orderNumber)
    {
        try
        {
            PreparedStatement st = connection.prepareStatement("DELETE FROM PRODUCT WHERE ORDER_NUM= ?");
            st.setInt(1, orderNumber);
            st.executeUpdate();
        } catch (SQLException ex)
        {
            System.out.println("SQL statement is not executed!" + ex);
        }
    }

    public void updateProduct(Product product)
    {
        try
        {
            PreparedStatement st = connection.prepareStatement("update PRODUCT set CUSTOMER_ID=?, PRODUCT_ID=?, QUANTITY=?, SHIPPING_COST=?, SALES_DATE =?, SHIPPING_DATE=?" + "where ORDER_NUM=?");

            st.setInt(1, product.getCustomerID());
            st.setInt(2, product.getProduct_ID());
            st.setInt(3, product.getQuantity());
            st.setInt(4, product.getShippingCost());
            st.setDate(5, new java.sql.Date(product.getSalesDate().getTime()));
            st.setDate(6, new java.sql.Date(product.getShippingDate().getTime()));
            st.setInt(7, product.getOrderNumber());

            st.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList<Product>();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from PRODUCT");
            while (rs.next())
            {
                Product product = new Product();
                product.setOrderNumber(rs.getInt("ORDER_NUM"));
                product.setCustomerID(rs.getInt("CUSTOMER_ID"));
                product.setProduct_ID(rs.getInt("PRODUCT_ID"));
                product.setQuantity(rs.getInt("QUANTITY"));
                product.setShippingCost(rs.getInt("SHIPPING_COST"));
                product.setSalesDate(rs.getDate("SALES_DATE"));
                product.setShippingDate(rs.getDate("SHIPPING_DATE"));

                products.add(product);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return products;
    }

    public Product getProductByOrderNumber(int orderNumber)
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
