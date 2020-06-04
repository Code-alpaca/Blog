package org.apache.jsp.register;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");

        String username = (String) request.getAttribute("notice");
        String notice = (String) request.getAttribute("notice");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>注册窗口</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <center>\r\n");
      out.write("            ><h1>jee web</h1>\r\n");
      out.write("        <table border=\"1px\" width=\"1000px\">\r\n");
      out.write("            <td>\r\n");
      out.write("                ");
 if(username == null) {
      out.write("\r\n");
      out.write("                <font size=\"2\">[<a href=\"/user/login.jsp \">请登录</a>][<a href=\"/user/login.jsp \">请注册</a>]</font>\r\n");
      out.write("                ");
 }else {
      out.write("\r\n");
      out.write("                <font size=\"2\">您好，</font><font color=\"red\">");
      out.print(username);
      out.write("</font>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("                \r\n");
      out.write("            </td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <font size=\"2\">\r\n");
      out.write("                    <a href=\"*/index/index.jsp\">首页</a>|\r\n");
      out.write("                    <a href=\"/\">用户信息</a>|\r\n");
      out.write("                    <a href=\"/\">查看日历</a>|\r\n");
      out.write("                    <a href=\"/\">公共留言</a>|\r\n");
      out.write("                    <a href=\"/\">好友列表</a>|\r\n");
      out.write("                    <a href=\"/\">私人留言</a>|\r\n");
      out.write("                    <a href=\"/\">信息论坛</a>\r\n");
      out.write("                </font>      \r\n");
      out.write("            </td>    \r\n");
      out.write("        </table>\r\n");
      out.write("          \r\n");
      out.write("            <h2>注册</h2>\r\n");
      out.write("            <form action=\"RegisterServlet\" method=\"post\">\r\n");
      out.write("                <table width=\"200\" border=\"1\" cellpadding=\"5\" bordercolor=\"green\"  Style=\"border-collapse:collapse\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                    <td colspan=\"2\" align=\"center\"><a href=\"login.jsp\">返回登录窗口</a></td>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>用户名</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"username\" size=\"10\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>密码</td>\r\n");
      out.write("                        <td><input type=\"password\" name=\"password1\" size=\"10\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>确认密码</td>\r\n");
      out.write("                        <td><input type=\"password\" name=\"password2\" size=\"10\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Email</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"email\" size=\"10\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"2\" align=\"center\"><input type=\"submit\" name=\"submit\" value=\"提交注册信息\"> </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </form>\r\n");
      out.write("            ");
 if (notice != null) {
      out.write("   <font color=\"red\">");
      out.print(notice);
      out.write("</font>   ");
 }
      out.write("\r\n");
      out.write("        </center>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
