package com.myapp.struts;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author willk
 */
public class RequestAction extends Action
{

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

 
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // extract user data
        RequestForm formBean = (RequestForm) form;
        
        int OrderNumber = formBean.getOrderNumber();
        int CustomerID = formBean.getCustomerID();
        int Product_ID = formBean.getProduct_ID();
        int Quantity = formBean.getQuantity();
        int ShippingCost = formBean.getShippingCost();
        Date SalesDate = formBean.getSalesDate();
        Date ShippingDate = formBean.getShippingDate();

        // perform validation
        if ((OrderNumber < 0) || (CustomerID < 0) || (Product_ID < 0) || (Quantity <= 0)
                || (ShippingCost < 0) || SalesDate == null || ShippingDate == null)
        {
            formBean.setError();
            return mapping.findForward(FAILURE);
        }

        return mapping.findForward(SUCCESS);
    }
}
