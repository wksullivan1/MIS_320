/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author willk
 */
public class ProductDeleteAction extends org.apache.struts.action.Action
{

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        HttpSession ses = request.getSession(true);
        // extract user data
        ProductBean formBean = (ProductBean) form;

        int orderNumber = formBean.getOrderNumber();
       

        //delete SQL data
        ProductDAO dao = new ProductDAO();
        dao.deleteData(orderNumber);
        ses.setAttribute("ORDER_NUM", orderNumber);
        if(Integer.toString(orderNumber).equals("")){
            return mapping.findForward("error");
        }

        return mapping.findForward(SUCCESS);
    }
}
