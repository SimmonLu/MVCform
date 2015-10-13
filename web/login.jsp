<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 10/12/15
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/MVCform/Controller" method="post">
    <input type="hidden" name="action" value="dologin" />
    Email: <input type="text" name="email" value="<%= request.getAttribute("email") %>"/>
    Password: <input type="text" name="password" value="<%= request.getAttribute("password") %>" />
    <input type="submit" value="OK" />

</form>

<h2><%= request.getAttribute("validationMessage") %></h2>
</body>
</html>
