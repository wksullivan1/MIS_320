/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author willk
 */
//public class ProductController extends HttpServlet{
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProductBean productBean = new ProductBean();
//        
//        productBean.setOrderNumber(Integer.parseInt("orderNumber"));
//        productBean.setCustomerID(Integer.parseInt("customerID"));
//        productBean.setProduct_ID(Integer.parseInt("product_ID"));
//        productBean.setQuantity(Integer.parseInt("quantity"));
//        productBean.setShippingCost(Integer.parseInt("shippingCost"));
//        
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//            
//            
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        try {
//            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
//            user.setDob(dob);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        
//    
//        if(userid == null || userid.isEmpty())
//        {
//            dao.addUser(user);
//        }
//        else
//        {
//            user.setUserid(Integer.parseInt(userid));
//            dao.updateUser(user);
//        }
//        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
//        request.setAttribute("users", dao.getAllUsers());
//        view.forward(request, response);
//    }
//}

    

