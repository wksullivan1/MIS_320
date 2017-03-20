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
        <title>Showing All Products</title>
    </head>
    <body>
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
            <c:forEach items="${products}" var="prod">
                <tr>
                    <td><c:out value="${prod.orderNumber}" /></td>
                    <td><c:out value="${prod.customerID}" /></td>
                    <td><c:out value="${prod.product_ID}" /></td>
                    <td><c:out value="${prod.quantity}" /></td>
                    <td><c:out value="${prod.shippingCost}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${prod.salesDate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${prod.shippingDate}" /></td>
                    <td><a href="ProductRegisterController?action=edit&orderNumber=<c:out value="${product.orderNumber}/>">Update</a></td>
                    <td><a href="ProductRegisterController?action=delete&orderNumber=<c:out value="${product.orderNumber}/>">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
                <p>
                    <a href="ProductRegisterController?action=insert">Add Product</a>
                </p>
</body>
</html>
