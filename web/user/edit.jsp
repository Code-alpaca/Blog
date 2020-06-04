<%-- 
    Document   : edit
    Created on : 2019-12-17, 17:42:25
    Author     : Administrator
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ResultSet rs=(ResultSet)request.getAttribute("rs");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="/head/head.jsp"></jsp:include>
	<center>
            修改信息
		<form action="<%=request.getContextPath()%>/UserServlet" method="post">
                    <%
                     if(rs==null){
                            out.print("错误!");
                    }else{
                        while(rs.next()){
                    %>
                    <input type="hidden" name="method" value="update"/>
                            <table border="1">
				<tr>
					<td>用户名</td>
					<td>
						<div name="username"><%=rs.getString(2)%></div>
					</td>
				</tr>
				<tr>
                                        <td>邮箱</td>
					<td><input type="text" name="email" value="<%=rs.getString(4)%>"></td>
				</tr>
				<tr>
                                        <td>性别</td>
					<td><input type="text" name="gender" value="<%=rs.getString(5)%>"></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><input type="text" name="birthday" value="<%=rs.getString(6)%>"></td>
				</tr>
				<tr>
                                        <td>电话</td>
					<td><input type="text" name="phone" value="<%=rs.getString(7)%>"></td>
				</tr>
				<tr>
                                        <td>地址</td>
					<td><input type="text" name="address" value="<%=rs.getString(8)%>"></td>
				</tr>
				<tr>
                                        <td>个人说明</td>
					<td><input type="text" name="personal" value="<%=rs.getString(9)%>"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="确认修改"></td>
				</tr>
			</table>
                    <%
                        }
                    }
                    %>

		</form>
	</center>

    </body>
</html>
