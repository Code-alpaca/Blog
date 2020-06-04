<%-- 
    Document   : show
    Created on : 2019-10-23, 18:25:48
    Author     : GGG
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String username=(String)request.getAttribute("username");
    String password=(String)request.getAttribute("password");
    String email=(String)request.getAttribute("email");
    String gender=(String)request.getAttribute("gender");
    String birthday=(String)request.getAttribute("birthday");
    String phone=(String)request.getAttribute("phone");
    String address=(String)request.getAttribute("address");
    String personnal=(String)request.getAttribute("personnal");
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
        <form action="<%=request.getContextPath()%>/UserServlet">
        <table border="1">
            
                
            <tr>
                <td width="100"align="center">用户名</td>
                <td><%=username%></td>
            </tr>
            <tr>
                <td width="100"align="center">密码</td>
                <td><%= password%></td>
            </tr>
            <tr>
                <td align="center">邮箱</td>
                <td><%= email%></td>
            </tr>
            <tr>
                <td align="center">性别</td>
                <td ><%= gender%></td>
            </tr>
            <tr>
                <td align="center">生日</td>
                <td><%= birthday%></td>
            </tr>
            <tr>
                <td align="center">电话</td>
                <td><%= phone%></td>
            </tr>
            <tr>
                <td align="center">住址</td>
                <td><%= address%></td>
            </tr>
            <tr>
                <td align="center">个人说明</td>
                <td><%=personnal%></td>
            </tr>
            
            
                    
                        
                
            
            
            </table>
            <input type="hidden" name="method" value="edit"/>
            <input type="submit" value="修改"/>
        </form>

    </center>
</body>
</html>

