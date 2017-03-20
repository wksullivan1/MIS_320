<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : response
    Created on : Mar 14, 2017, 1:40:08 PM
    Author     : willk
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <sql:setDataSource var="con" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/MyDatabase" />
    <sql:query var="DisplayAll" dataSource="${con}" >
        SELECT * FROM PRODUCT
    </sql:query>
    
    <table border="1">
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
</html>
