package com.wksullivan1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author willk
 */
public class ProductController extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/request.jsp";
    private static String LIST_PRODUCT = "/response.jsp";
    private ProductDao dao;
    String x = "0";

    public ProductController()
    {
        super();
        dao = new ProductDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String forward = "";

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete"))
        {
            int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
            dao.deleteProduct(orderNumber);
            forward = LIST_PRODUCT;
            request.setAttribute("products", dao.getAllProducts());
        } else if (action.equalsIgnoreCase("edit")){
            x = "1";
            forward = INSERT_OR_EDIT;
            int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
            Product product = dao.getProductByOrderNumber(orderNumber);
            request.setAttribute("product", product);
        } else if (action.equalsIgnoreCase("listProduct"))
        {
            forward = LIST_PRODUCT;
            request.setAttribute("products", dao.getAllProducts());
        } else
        {
            forward = INSERT_OR_EDIT;
        }

        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Product product = new Product();
        product.setOrderNumber(Integer.parseInt(request.getParameter("orderNumber")));
        product.setCustomerID(Integer.parseInt(request.getParameter("customerID")));
        product.setProduct_ID(Integer.parseInt(request.getParameter("product_ID")));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        product.setShippingCost(Integer.parseInt(request.getParameter("shippingCost")));

        try
        {
            Date salesDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("salesDate"));
            product.setSalesDate(salesDate);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        try
        {
            Date shippingDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("shippingDate"));
            product.setShippingDate(shippingDate);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        String orderNumber = request.getParameter("orderNumber");


        if (orderNumber != null && x == "0")
        {
            dao.addProduct(product);
        } else
        {
            product.setOrderNumber(Integer.parseInt(orderNumber));
            dao.updateProduct(product);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCT);
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }

}
