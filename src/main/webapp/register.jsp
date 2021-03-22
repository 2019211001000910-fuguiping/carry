<%--
  Created by IntelliJ IDEA.
  User: 付贵平
  Date: 2021/3/22
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  method="post" action="register">
    username<input type="text" name="username"/><br/>
    password<input type="text" name="password"/><br/>
    Email<input type="text" name="email"/><br/>Gender:<input type="radio" name="gender" value="male"/>Male<input type="radio" name="gender" value="female"/>FeMale<br/>
    Date of Birth:<input type="text" name="birthDate"/><br/>
    <input type="submit" name="Register"/>
</form>
</body>
</html>
