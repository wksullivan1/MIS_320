<%-- 
    Document   : response
    Created on : Mar 14, 2017, 1:40:08 PM
    Author     : willk
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <h1>Congratulations!</h1>

        <p>You have successfully logged in.</p>

        <p>Your Order Number is :<bean:write name="RequestForm" property="orderNumber" /> .</p>

        <p>Your Customer ID is:<bean:write name="RequestForm" property="customerID" /> .</p>

        <p>Your Product ID is:<bean:write name="RequestForm" property="product_ID" /> .</p>

        <p>Your Quantity is:<bean:write name="RequestForm" property="quantity" /> .</p>

        <p>Your Shipping Cost is:<bean:write name="RequestForm" property="shippingCost" /> .</p>

        <p>Your Sales Date is:<bean:write name="RequestForm" property="salesDate" /> .</p>

        <p>Your Shipping Date is:<bean:write name="RequestForm" property="shippingDate" /> .</p>
    </body>
</html>
