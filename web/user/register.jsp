<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
        String username = (String) request.getAttribute("notice");
        String notice = (String) request.getAttribute("notice");
%>
<html>
    <head>
        <title>注册窗口</title>
    </head>

    <body>
        <center>
            <jsp:include page="/head/head.jsp"></jsp:include>
          
            <h2>注册</h2>
            <form action="<%=request.getContextPath()%>/RegisterServlet" method="post">
                <table width="200" border="1" cellpadding="5" bordercolor="green"  Style="border-collapse:collapse">
                    <tr>
                    <td colspan="2" align="center"><a href="login.jsp">返回登录窗口</a></td>
                    <tr>
                        <td>用户名</td>
                        <td><input type="text" name="username" size="10"></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><input type="password" name="password1" size="10"></td>
                    </tr>
                    <tr>
                        <td>确认密码</td>
                        <td><input type="password" name="password2" size="10"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" size="10"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" name="submit" value="提交注册信息"> </td>
                    </tr>
                </table>
            </form>
            <% if (notice != null) {%>   <font color="red"><%=notice%></font>   <% }%>
        </center>
    </body>
</html>
