<%--
  Created by IntelliJ IDEA.
  User: 付贵平
  Date: 2021/3/16
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script language="javascript">

    var t = null;

    t = setTimeout(time,1000);//开始执行

    function time()

    {

        clearTimeout(t);//清除定时器

        dt = new Date();

        var y=dt.getYear()+1900;

        var mm=dt.getMonth()+1;

        var d=dt.getDate();

        var weekday=["Sum","Mon","Tue","Wed","Thu","Fri","Sat"];

        var day=dt.getDay();

        var h=dt.getHours();

        var m=dt.getMinutes();

        var s=dt.getSeconds();
        if(h<10){h="0"+h;}

        if(m<10){m="0"+m;}

        if(s<10){s="0"+s;}

        document.getElementById("timeShow").innerHTML =  "现在的时间为："+y+"年"+mm+"月"+d+"日"+weekday[day]+" "+h+":"+m+":"+s+"";

        t = setTimeout(time,1000); //设定定时器，循环执行

    }

</script>

<body>
<a href="index.jsp">go to week1</a>
<form method="gost">
    Name: Fu Guiping</br>
    ID: 2019211001000910</br>
    <div id="timeShow" class="time1"></div>
</form>
</body>
</html>
