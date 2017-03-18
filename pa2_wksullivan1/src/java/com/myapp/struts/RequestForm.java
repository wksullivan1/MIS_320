package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author willk
 */
public class RequestForm extends org.apache.struts.action.ActionForm
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

    public void setError()
    {
        this.error = "<span style='color:red'>Please provide valid entries for both fields</span>";
    }

    public RequestForm()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        ActionErrors errors = new ActionErrors();
        if (getOrderNumber() < 1)
        {
            errors.add("OrderNumber", new ActionMessage("error.OrderNumber.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getCustomerID() < 1)
        {
            errors.add("CustomerID", new ActionMessage("error.CustomerID.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getProduct_ID() < 1)
        {
            errors.add("Product_ID", new ActionMessage("error.Product_ID.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getQuantity() < 1)
        {
            errors.add("Quantity", new ActionMessage("error.Quantity.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getShippingCost() < 1)
        {
            errors.add("ShippingCost", new ActionMessage("error.ShippingCost.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getSalesDate() == null)
        {
            errors.add("SalesDate", new ActionMessage("error.SalesDate.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getShippingDate() == null)
        {
            errors.add("ShippingDate", new ActionMessage("error.ShippingDate.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }

}
