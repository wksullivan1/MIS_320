package com.myapp.struts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private Connection connection;

    public ProductDao() {
        connection = DbConnectionUtil.getConnection();
    }

    public void addProduct(ProductBean product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into PRODUCT(ORDER_NUM,CUSTOMER_ID,PRODUCT_ID,QUANTITY,SHIPPING_COST,SALES_DATE,SHIPPING_DATE) values (?, ?, ?, ?, ?, ?, ? )");

            preparedStatement.setInt(1, product.getOrderNumber());
            preparedStatement.setInt(2, product.getCustomerID());
            preparedStatement.setInt(3, product.getProduct_ID());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getShippingCost());
            preparedStatement.setDate(6, (Date) product.getSalesDate());
            preparedStatement.setDate(7,(Date) product.getShippingDate());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int orderNumber) {
        
        
    }

    public void updateProduct(ProductBean product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update PRODUCT set ORDER_NUM=?, CUSTOMER_ID=?, PRODUCT_ID=?, QUANTITY=?, SHIPPING_COST=?, SALES_DATE=?, SHIPPING_DATE=?" + "where oORDER_NUM=?");

            preparedStatement.setInt(1, product.getOrderNumber());
            preparedStatement.setInt(2, product.getCustomerID());
            preparedStatement.setInt(3, product.getProduct_ID());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getShippingCost());
            preparedStatement.setDate(6, (Date) product.getSalesDate());
            preparedStatement.setDate(7,(Date) product.getShippingDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ProductBean> getAllProducts() {
        List<ProductBean> products = new ArrayList<ProductBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Product");
            while (rs.next()) {
                ProductBean product = new ProductBean();
                product.setOrderNumber(rs.getInt("orderNumber"));
                product.setCustomerID(rs.getInt("customerID"));
                product.setProduct_ID(rs.getInt("product_ID"));
                product.setQuantity(rs.getInt("quantity"));
                product.setShippingCost(rs.getInt("shippingCost"));
                product.setSalesDate(rs.getDate("salesDate"));
                product.setShippingDate(rs.getDate("shippingDate"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public ProductBean getProductByID(int orderNumber) {
        ProductBean product = new ProductBean();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from PRODUCT where ORDER_NUM=?");
            preparedStatement.setInt(1, orderNumber);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                product.setOrderNumber(rs.getInt("orderNumber"));
                product.setCustomerID(rs.getInt("customerID"));
                product.setProduct_ID(rs.getInt("product_ID"));
                product.setQuantity(rs.getInt("quantity"));
                product.setShippingCost(rs.getInt("shippingCost"));
                product.setSalesDate(rs.getDate("salesDate"));
                product.setShippingDate(rs.getDate("shippingDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
