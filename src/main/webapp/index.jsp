<%@include file="header.jsp"%>
<h1>Welcome to My Online Shop Home Page</h1>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu"><a href="http://www.baidu.com/">Baidu</a></option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>
<a href="hello-servlet">hello servlet-week1</a></br>
<a href="hello">Student Info Servlet-week2</a></br>
<a href="life">life Cycle Servlet-week3</a></br>
<a href="register.jsp">Register-getParameter-week3</a></br>
<a href="config"> Config parameter-week4</a></br>
<a href="register.jsp">Register JDBC-week4</a></br>
<a href="index.jsp">include-week5</a></br>
<a href="login.jsp">login-week5</a></br>
<%--<a href="userList.jsp">userList-week6</a></br>--%>
<%--<a href="userInfo.jsp">userInfo-week6</a></br>--%>
<%--<a href="redirect">redirect-week6</a></br>--%>
<%--<a href="search">search-week6</a></br>--%>
<%@include file="footer.jsp"%>