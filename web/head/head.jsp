<%-- 
    Document   : head
    Created on : 2019-12-10, 17:28:10
    Author     : Administrator
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
        <h1>jee web</h1>
        <table border="1px" width="1000px">
            <td>
                <% if(username == null) {%>
                <font size="2">[<a href="<%=request.getContextPath()%>/user/login.jsp ">请登录</a>][<a href="<%=request.getContextPath()%>/user/register.jsp ">请注册</a>]</font>
                <% }else {%>
                <font size="2">您好，</font><font color="red"><%=username%></font>[<a href="<%=request.getContextPath()%>/logoutServlet">退出</a>]
                <%}%>
                
            </td>
            <td>
                <font size="2">
                    <a href="<%=request.getContextPath()%>/index/index.jsp">首页</a>|
                    <a href="<%=request.getContextPath()%>/UserServlet?method=show">用户信息</a>|
                    <a href="<%=request.getContextPath()%>/time/calendar.jsp">查看日历</a>|
                    <a href="<%=request.getContextPath()%>/message/message.jsp">公共留言</a>|
                    <a href="/">好友列表</a>|
                    <a href="/">私人留言</a>|
                    <a href="/">信息论坛</a>
                </font>      
            </td>    
        </table>
    </center>
    </body>
</html>
