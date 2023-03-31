<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Login Servlet</title>
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
            color: #4775e3;
            padding: 15px;
            margin-top: 2rem;
        }
    </style>
</head>
<body>
<h1 id="title-banner"><%= "Welcome to Login!" %>
</h1>
<br/>
<form method="post" action="/login_servlet_war_exploded/login">
    <div>
        <b><label>Enter Username:</label></b>
        <input type="text" name="userName" required/>
    </div>
    <div>
        <b><label>Enter Password:</label></b>
        <input type="password" name="password" required/>
    </div>
    <div>
        <input type="submit" value="Validate Credentials" />
    </div>
</form>
</body>
</html>