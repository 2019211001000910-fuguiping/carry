<%--
  Created by IntelliJ IDEA.
  User: 付贵平
  Date: 2021/3/22
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@include file="WEB-INF/views/header.jsp"%>
<form  style="text-align:center" method="post" action="register">
    <!--<input type="text" name="userid" value="" placeholder="登录名"/>-->
    <h1 style="text-align:center;color:#80002d" >register</h1></br>
    username:<input type="text" name="username" value="username"
                    onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                    onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;background: #EAEAAE" /><br/><br/>
    password:<input type="password" name="password" value="password"
                    onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                    onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;background: #EAEAAE" /><br/><br/>

    Email:<input type="Email" name="email" value="email"
                 onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                 onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;background: #EAEAAE" /><br/><br/>

    <input type="radio" name="gender"  id="man1" value="Male" />
    <label for="man1">Male</label>
    <input type="radio" name="gender" id="man2" value="Female" />
    <label for="man2">Female</label><br/><br/>
    birthDate:<input type="date" name="birthDate" value="birthDate"
                     onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                     onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;background: #EAEAAE" />
    <input type="submit" name="Submit" value="Submit" />
    <input type="submit" name="Submit2" value="reset" />
</form>
<%@include file="WEB-INF/views/footer.jsp"%>
