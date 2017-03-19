<%-- 
    Document   : request
    Created on : Mar 14, 2017, 1:23:06 PM
    Author     : willk
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Form</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    </head>
    <body>

        <h1>Request Form</h1>
        <html:form action="/request">
            <table border="0">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <bean:write name="ProductBean" property="error" filter="false"/>
                            &nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td>Enter your Order Number</td>
                        <td><html:text property="orderNumber" /></td>
                    </tr>
                    <tr>
                        <td>Enter your customer ID</td>
                        <td><html:text property="customerID" /></td>
                    </tr>
                    <tr>
                        <td>Enter your Product ID</td>
                        <td><html:text property="product_ID" /></td>
                    </tr>
                    <tr>
                        <td>Enter your Quantity</td>
                        <td><html:text property="quantity" /></td>
                    </tr>
                    <tr>
                        <td>Enter your Shipping Cost</td>
                        <td><html:text property="shippingCost" /></td>
                    </tr>
                    <tr>
                        <td>Enter your Sales Date</td>
                        <td><input property ="salesDate" type="date" name="salesDate"></td>
                    </tr>
                    <tr>
                        <td>Enter your Shipping Date</td>
                        <td><input property ="shippingDate" type="date" name="shippingDate"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><html:submit value="Request"/></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
    </body>
</html>
