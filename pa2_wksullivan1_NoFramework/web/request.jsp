<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link type="text/css"
              href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title>Add new product</title>
    </head>
    <body>
   
        RESPONSE PAGE
        <form method="POST" action='ProductController'  name="frmAddProduct">            
            Order Number : <input type="text" name="orderNumber" value="<c:out value="${product.orderNumber}" />" /> <br /> 
            Customer ID : <input  type="text" name="customerID" value="<c:out value="${product.customerID}" />" /> <br /> 
            Product ID : <input  type ="text" name="product_ID" value="<c:out value="${product.product_ID}" />" /> <br />
            Quantity : <input type="text"  name="quantity" value="<c:out value="${product.quantity}" />" /> <br />
            Shipping Cost : <input type=" text " name="shippingCost" value="<c:out value="${product.shippingCost}" />" /> <br />
            Sales Date : <input type="date" name="salesDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${product.salesDate}" />" /> <br />            
            Shipping Date : <input type="date" name="shippingDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${product.shippingDate}" />" /> <br /> 
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
