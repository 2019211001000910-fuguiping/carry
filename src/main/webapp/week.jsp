<%--
  Created by IntelliJ IDEA.
  User: 付贵平
  Date: 2021/3/16
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<!--定义表单 form-->
<form action="#" method="post">
    <table border="1" align="center" width="500">
        <tr>
            <td><label for="username">usename</label></td>
            <td><input type="text" name="username" id="username"></td>
        </tr>

        <tr>
            <td><label for="password">password</label></td>
            <td><input type="password" name="password" id="password" ></td>
        </tr>

        <tr>
            <td><label for="email">Email</label></td>
            <td><input type="email" name="email" id="email"></td>
        </tr>



        <tr>
            <td><label for="tel">Telephone</label></td>
            <td><input type="text" name="tel" id="tel"></td>
        </tr>

        <tr>
            <td><label>Gender</label></td>
            <td><input type="radio" name="gender" value="male"> Male
                <input type="radio" name="gender" value="female"> Female
            </td>
        </tr>

        <tr>
            <td><label for="birthday">Date of Birth</label></td>
            <td><input type="date" name="birthday" id="birthday"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Register"></td>
        </tr>
    </table>


</form>

</body>
</html>
