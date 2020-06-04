<%-- 
    Document   : newjsp
    Created on : 2019-11-5, 17:08:16
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Calender" class="timeServlet.Calender" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
    <center>
        <jsp:include page="/head/head.jsp"></jsp:include>
        <form action="">
            输入日历的年份:<input name="year"/>选择日历的月份：
             <select name="month">
                 <option value="1">一月  <option value="2">二月
                 <option value="3">三月  <option value="4">四月
                 <option value="5">五月  <option value="6">六月
                 <option value="7">七月  <option value="8">八月
                 <option value="9">九月  <option value="10">十月
                 <option value="11">十一月  <option value="12">十二月
             </select>

             <input type="submit" value="提交">
        </form>
        <jsp:setProperty name="Calender" property="*"/>
        <h2>
            <jsp:getProperty name="Calender" property="year"/>年<jsp:getProperty name="Calender" property="month"/>月的日历
        </h2>
            <jsp:getProperty name="Calender" property="calendar"/>
    </center>
    </body>
</html>
