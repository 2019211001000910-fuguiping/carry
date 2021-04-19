<%--
  Created by IntelliJ IDEA.
  User: 付贵平
  Date: 2021/4/11
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form style="text-align: center;background: deepskyblue" method="post" action="login">
    <h1 style="text-align: center;color: #788dad">login</h1>
    <%
        if (request.getAttribute("message")==null)
            out.println(request.getAttribute("message"));
    %>
    <input type="text" name="username" value="" placeholder="username"></br></br>
    <input type="password" name="password" value="" placeholder="password"></br></br>
    <input type="submit" name="login" value="login">
</form>

<%@include file="footer.jsp"%>
