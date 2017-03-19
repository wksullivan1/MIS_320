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
        <p>Your Order Number is :<bean:write name="ProductBean" property="orderNumber" /> .</p>
        <p>Your Customer ID is:<bean:write name="ProductBean" property="customerID" /> .</p>
        <p>Your Product ID is:<bean:write name="ProductBean" property="product_ID" /> .</p>
        <p>Your Quantity is:<bean:write name="ProductBean" property="quantity" /> .</p>
        <p>Your Shipping Cost is:<bean:write name="ProductBean" property="shippingCost" /> .</p>
        <p>Your Sales Date is:<bean:write name="ProductBean" property="salesDate" /> .</p>
        <p>Your Shipping Date is:<bean:write name="ProductBean" property="shippingDate" /> .</p>
        
       
        
        <table border=1>
                <thead>
                    <tr>
                        <th>Order Number</th>
                        <th>Customer ID</th>
                        <th>Product ID</th>
                        <th>Quantity</th>
                        <th>Shipping Cost</th>
                        <th>Sales Date</th>
                        <th>Shipping Date</th>                         
                        <th colspan=2>Action</th>
                    </tr>
                </thead>
                <tbody>
            
                    <c:forEach items="${productList}" var="prod">
                        <tr>
                            <td><c:out value="${prod.orderNumber}" /></td>
                            <td><c:out value="${emp.ename}" /></td>
                            <td><c:out value="${emp.enumber}" /></td>

                            <td>
                                <form action="EmployeeController" method="POST">
                                    <a href='' onclick="this.href='EmployeeController?action=update&id=<c:out value="${emp.id}"/>&enamenew='+document.getElementById('enamenew').value+'&enumberupdatenew='+document.getElementById('enumberupdatenew').value">Update</a>
                                </form>
                            </td>
                                   
                            <td><a href="EmployeeController?action=delete&id=<c:out value="${emp.id}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </body>
</html>
