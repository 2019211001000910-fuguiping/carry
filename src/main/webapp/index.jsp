<%@include file="header.jsp"%>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!!!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form  method="post" action="register">
    username<input type="text" name="username"/><br/>
    password<input type="text" name="password"/><br/>
    Email<input type="text" name="email"/><br/>Gender:<input type="radio" name="gender" value="male"/>Male<input type="radio" name="gender" value="female"/>FeMale<br/>
    Date of Birth:<input type="text" name="birthDate"/><br/>
    <input type="submit" name="Register"/>
</form>
</body>
<%@include file="footer.jsp"%>