package com.myapp.struts;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author willk
 */
public class ProductRegisterAction extends Action
{

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

 
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        HttpSession ses = request.getSession(true);
        // extract user data
        ProductBean formBean = (ProductBean) form;
        
        int orderNumber = formBean.getOrderNumber();
        int customerID = formBean.getCustomerID();
        int product_ID = formBean.getProduct_ID();
        int quantity = formBean.getQuantity();
        int shippingCost = formBean.getShippingCost();
        Date salesDate = formBean.getSalesDate();
        Date shippingDate = formBean.getShippingDate();
        
        
        //insert SQL data
        ProductDAO dao = new ProductDAO();
        dao.insertData(orderNumber,customerID,product_ID,quantity,shippingCost,salesDate,shippingDate);
        ses.setAttribute("ORDER_NUM",orderNumber);
        ses.setAttribute("CUSTOMER_ID",customerID);
        ses.setAttribute("PRODUCT_ID",product_ID);
        ses.setAttribute("QUANTITY",quantity);
        ses.setAttribute("SHIPPING_COST",shippingCost);
        ses.setAttribute("SALES_DATE",salesDate);
        ses.setAttribute("SHIPPING_DATE",shippingDate);

        // perform validation
        if ((orderNumber < 0) || (customerID < 0) || (product_ID < 0) || (quantity <= 0)|| (shippingCost < 0) || salesDate == null || shippingDate == null)
        {
            formBean.setError();
            return mapping.findForward(FAILURE);
        }
        return mapping.findForward(SUCCESS);
    }
}
