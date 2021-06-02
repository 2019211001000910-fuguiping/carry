<%--
  Created by IntelliJ IDEA.
  User: 付贵平
  Date: 2021/6/2
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="htt:p//java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%-- todo 9: use c:out to print message fron request --%>
<%--<%=request.getAttribute("message")%>--%>
<c:out value="${sessionScope.message}"/>
<%--todo 1: use c:url to set url in action="validate.jsp" --%>
<c:url value="/lab1/assignment2/validate.jsp" var="check"/>
<form action="${check}">
    Username : <input type="text" name="username"><br>
    Password : <input type="password" name="password"><br>
    <input type="submit" value="Login"/>
</form>

</body>
</html>

