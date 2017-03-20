package com.myapp.struts;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//https://docs.oracle.com/cd/E17802_01/products/products/servlet/2.1/api/javax.servlet.http.HttpServlet.html

public class ProductRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/request.jsp";
    private static String LIST_PRODUCT = "/response.jsp";
    private ProductDao dao;

    public ProductRegisterController() {
        super();
        dao = new ProductDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String forward="";
     
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
            dao.deleteProduct(orderNumber);
            forward = LIST_PRODUCT;
            request.setAttribute("products", dao.getAllProducts());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
            ProductBean product = dao.getProductByID(orderNumber);
            request.setAttribute("product", product);
        } else if (action.equalsIgnoreCase("listProduct")){
            forward = LIST_PRODUCT;
            request.setAttribute("products", dao.getAllProducts());
        } else {
            forward = INSERT_OR_EDIT;
        }

        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);
        
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductBean product = new ProductBean();
        
        product.setOrderNumber(Integer.parseInt("orderNumber"));
        
        product.setCustomerID(Integer.parseInt("customerID"));
        
        product.setProduct_ID(Integer.parseInt("product_ID"));
        
        product.setQuantity(Integer.parseInt("quantity"));
        
        product.setShippingCost(Integer.parseInt("shippingCost"));
        
        
        
        try {
            Date salesDate1 = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("salesDate"));
            product.setSalesDate(salesDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        try {
            Date shippingDate1 = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("shippingDate"));
            product.setSalesDate(shippingDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCT);
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }
}