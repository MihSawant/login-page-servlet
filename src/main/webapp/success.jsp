<%--
  Created by IntelliJ IDEA.
  User: mihirsanjaysawant
  Date: 01/04/23
  Time: 1:11 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
<h1 style="color: #5dbb00"><% out.print("Credentials Are Correct, Welcome "+request.getParameter("userName")); %></h1>
</body>
</html>
