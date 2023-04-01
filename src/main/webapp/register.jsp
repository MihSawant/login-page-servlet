<%--
  Created by IntelliJ IDEA.
  User: mihirsanjaysawant
  Date: 01/04/23
  Time: 12:33 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<style>
    *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    form>div{
        padding: 20px;
    }
    body{
        text-align: center;
    }
    #title-banner{
        color: #47e3d6;
        padding: 15px;
        margin-top: 2rem;
    }
</style>
<body>
<h1 id="title-banner"><%= "Please Register!" %>
<form method="post" action="/login_servlet_war_exploded/register">
    <div>
        <b><label>Enter Username:</label></b>
        <input type="text" name="userName" required/>
    </div>
    <div>
        <b><label>Enter Password:</label></b>
        <input type="password" name="password" required/>
    </div>
    <div>
        <input type="submit" value="Register User" />
    </div>
</form>
</body>
</html>
