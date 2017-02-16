<%-- 
    Document   : success
    Created on : Feb 15, 2017, 7:35:44 PM
    Author     : WKS Desktop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">

    </head>
    <body>
        <h1>Congratulations!</h1>

        <p>You have successfully logged in.</p>

        <p>Your name is: <bean:write name="LoginForm" property="name" />.</p>

        <p>Your email address is: <bean:write name="LoginForm" property="email" />.</p>
    </body>
</html>
