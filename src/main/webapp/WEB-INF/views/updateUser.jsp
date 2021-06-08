<%--
  Created by IntelliJ IDEA.
  User: 付贵平
  Date: 2021/6/8
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>Update User</h1>

<%
    User u = (User) session.getAttribute("user");
%>

<form method="post" action="updateUser">
    NEW USER REGISTRATION<br/>

    <input type="hidden" name="id" value="<%=u.getId()%>">

    <label for="Username">USERNAME</label><br/>
    <input type="text" name="Username" id="Username" value="<%=u.getUsername()%>" placeholder="Please input username"
           required autofocus><br/>

    <label for="Password">PASSWORD</label><br/>
    <input type="password" name="Password" id="Password" value="<%=u.getPassword()%>"
           placeholder="Please input password" required autofocus minlength="8"><br/>

    <label for="Email">EMAIL</label><br/>
    <input type="email" name="Email" id="Email" value="<%=u.getEmail()%>" placeholder="Please input Email" required
           autofocus><br/>

    <input type="radio" name="Gender" value="Male" <%="Male".equals(u.getGender()) ? "checked" : ""%> />Male

    <input type="radio" name="Gender" value="Female" <%="Female".equals(u.getGender()) ? "checked" : ""%> />Female<br/>

    <label for="BirthDate">BIRTHDATE</label><br/>
    <input type="date" name="BirthDate" id="BirthDate" value="<%=u.getBirthDate()%>"
           placeholder="Day of Birth (yyyy-mm-dd)"><br/>

    <input type="submit" value="Update"/><br/>

</form>
<%@include file="footer.jsp" %>
