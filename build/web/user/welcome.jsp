<%-- 
    Document   : welcome
    Created on : 2019-12-15, 21:44:32
    Author     : 丁如超
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String username=(String)session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <jsp:include page="/head/head.jsp"></jsp:include>
        <h2 style="color: #00cc99">用户<font color="red"><%=username%></font>登录成功！</h2>
        <h2 style="color: #00cc99">欢迎使用留言板</h2>
        <h2 style="color: #00cc99">可以使用其他功能了！</h2>
        </center>
    </body>
</html>
