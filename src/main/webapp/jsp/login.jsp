<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="loginForm" method="post" action="/quadrangle/main">
    <input type="hidden" name="commandName" value="login_command">
    Login:<br/>
    <input type="text" name="login"/><br/>
    Password:<br/>
    <input type="password" name="password"/><br/>
    ${errorLoginPasswordMessage}<br/>Incorrect login or password
    <input type="submit" name="Login"/>
</form>
</body>
</html>
