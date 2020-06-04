<%-- 
    Document   : index
    Created on : 2019-12-15, 19:50:00
    Author     : 丁如超
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String error=(String)request.getAttribute("error");
    String a=(String)request.getAttribute("a");
    String b=(String)request.getAttribute("b");
    String notice=(String)request.getAttribute("notice");
    String c=(String)request.getAttribute("error");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录</title>
    </head>
    <body>
        <center>
                <jsp:include page="/head/head.jsp"></jsp:include>
                <br><font size="5px">登录</font><br>
                <br>              
                <form action="<%=request.getContextPath()%>/Check">
                    
                    账号：<input type="text" name="username"  <%if(error!=null){%>value=<%=a%><%}%>>
                    <% if(error!=null&&error.equals("账号未输入")){
                        out.print("<font color=red>"+error+"</font>");
                    }
                    %>
                    <br>
                    密码：<input type="text" name="password"  <%if(error!=null&&error.equals("邮箱未输入")){%>value=<%=b%><%}%>>
                    <% if(error!=null&&error.equals("密码未输入")){
                        out.print("<font color=red>"+error+"</font>");
                    }
                    %>
                    <br>
                    邮箱：<input type="text" name="email"  >
                    <% if(error!=null&&error.equals("邮箱未输入")){
                        out.print("<font color=red>"+error+"</font>");
                    }
                    %><input name="method" type="hidden" value="show">
                    <br>
                    <input type="submit" value="提交"><br>
                    <a href="register.jsp">注册新用户</a><br>
                    <% if(notice!= null){ %><font color="red"><%= notice%></font><%}%>
                    <% if(c!= null){ %><font color="red"><%= c%></font><%}%> 
                </form>
    </center>
    </body>
</html>
