/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

/**
 *
 * @author willk
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ProductDAO
{

    public void insertData(int orderNumber, int customerID, int product_ID, int quantity, int shippingCost, Date salesDate, Date shippingDate) throws Exception
    {

        System.out.println("jdbc connection");
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDatabase;user=mis320;password=mis320");
        try
        {
            try
            {

                String sql = "INSERT INTO PRODUCT(ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST,SALES_DATE,SHIPPING_DATE) VALUES(?,?,?,?,?,?,?)";

                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, orderNumber);
                st.setInt(2, customerID);
                st.setInt(3, product_ID);
                st.setInt(4, quantity);
                st.setInt(5, shippingCost);
                st.setDate(6, salesDate);
                st.setDate(7, shippingDate);

                st.executeUpdate();
                st.close();
            } catch (SQLException ex)
            {
                System.out.println("SQL statement is not executed!" + ex);
            }
            con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteData(int orderNumber) throws Exception
    {
        System.out.println("jdbc connection");
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDatabase;user=mis320;password=mis320");
        try
        {
            try
            {
                String sql = "DELETE FROM PRODUCT WHERE ORDER_NUM= ?";

                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, orderNumber);                
                st.executeUpdate();
                st.close();
            } catch (SQLException ex)
            {
                System.out.println("SQL statement is not executed!" + ex);
            }
            con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void updateData(int orderNumber, int customerID, int product_ID, int quantity, int shippingCost, Date salesDate, Date shippingDate) throws Exception{
        System.out.println("jdbc connection");
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDatabase;user=mis320;password=mis320");
        try
        {
            try
            {
                String sql = "update PRODUCT set CUSTOMER_ID = ?, PRODUCT_ID = ?, QUANTITY = ?, SHIPPING_COST = ?, SALES_DATE = ?, SHIPPING_DATE = ? where ORDER_NUM = ?";

                PreparedStatement st = con.prepareStatement(sql);
                
                st.setInt(1, customerID);
                st.setInt(2, product_ID);
                st.setInt(3, quantity);
                st.setInt(4, shippingCost);
                st.setDate(5, salesDate);
                st.setDate(6, shippingDate);
                st.setInt(7, orderNumber);

                st.executeUpdate();
                st.close();
            } catch (SQLException ex)
            {
                System.out.println("SQL statement is not executed!" + ex);
            }
            con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
