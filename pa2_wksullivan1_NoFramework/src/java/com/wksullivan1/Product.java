/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wksullivan1;

import java.util.Date;

/**
 *
 * @author willk
 */
public class Product
{
    private int orderNumber;
    private int customerID;
    private int product_ID;
    private int quantity;
    private int shippingCost;
    private Date salesDate;
    private Date shippingDate;
    private String error;
    
    public int getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public int getProduct_ID()
    {
        return product_ID;
    }

    public void setProduct_ID(int product_ID)
    {
        this.product_ID = product_ID;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getShippingCost()
    {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost)
    {
        this.shippingCost = shippingCost;
    }

    public Date getSalesDate()
    {
        return salesDate;
    }

    public void setSalesDate(Date salesDate)
    {
        this.salesDate = salesDate;
    }

    public Date getShippingDate()
    {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate)
    {
        this.shippingDate = shippingDate;
    }
 
    public String getError()
    {
        return error;
    }    
}
