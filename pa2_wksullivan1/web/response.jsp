

<%-- 
    Document   : response
    Created on : Mar 14, 2017, 1:40:08 PM
    Author     : willk
--%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <script>
        function search() {
            var input, filter, found, table, tr, td, i, j;
            input = document.getElementById("searchTextBox");
            filter = input.value.toUpperCase();
            table = document.getElementById("tableID");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td");
                for (j = 0; j < td.length; j++) {
                    if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
                        found = true;
                    }
                }
                if (found) {
                    tr[i].style.display = "";
                    found = false;
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    </script>
    <body>
        <sql:setDataSource var="con" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/MyDatabase;user=mis320;password=mis320" />
        <sql:query var="DisplayAll" dataSource="${con}" >
            SELECT * FROM PRODUCT
        </sql:query>

        <table border="1" id = "tableID">
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${DisplayAll.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                    </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${DisplayAll.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>                    
                    </c:forEach>                
                </tr>            
            </c:forEach>
        </table>
        <p><a href="request.jsp">Add User</a></p>


        <html:form action="/delete">   
            Enter your Order Number to be deleted:
            <html:text property="orderNumber" />
            <html:submit value="Delete"/>
        </html:form>
            <br>
        <html:form action="/update">   
            Enter your Order Information to be updated
            <br>
            Order Number:<html:text property="orderNumber" /><br>
            Customer ID:<html:text property="customerID" /><br>
            Product ID:<html:text property="product_ID" /><br>
            Quantity:<html:text property="quantity" /><br>
            Shipping Cost:<html:text property="shippingCost" /><br>
            Sales Date:<html:text property="salesDate" /><br>
            Shipping Date:<html:text property="shippingDate" />  <br>         
            
            <html:submit value="Update"/>
        </html:form>             


        Enter your order number to be searched:<input type="text" id ="searchTextBox"/><button onclick ="search()">Search</button>
    </body>
</html>
