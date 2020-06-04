package org.apache.jsp.head;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class head_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");

    String username=(String)session.getAttribute("username");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        <h1>jee web</h1>\n");
      out.write("        <table border=\"1px\" width=\"1000px\">\n");
      out.write("            <td>\n");
      out.write("                ");
 if(username == null) {
      out.write("\n");
      out.write("                <font size=\"2\">[<a href=\"");
      out.print(request.getContextPath());
      out.write("/user/login.jsp \">请登录</a>][<a href=\"");
      out.print(request.getContextPath());
      out.write("/user/register.jsp \">请注册</a>]</font>\n");
      out.write("                ");
 }else {
      out.write("\n");
      out.write("                <font size=\"2\">您好，</font><font color=\"red\">");
      out.print(username);
      out.write("</font>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                \n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                <font size=\"2\">\n");
      out.write("                    <a href=\"");
      out.print(request.getContextPath());
      out.write("/index/index.jsp\">首页</a>|\n");
      out.write("                    <a href=\"");
      out.print(request.getContextPath());
      out.write("/UserServlet?method=show\">用户信息</a>|\n");
      out.write("                    <a href=\"/\">查看日历</a>|\n");
      out.write("                    <a href=\"/\">公共留言</a>|\n");
      out.write("                    <a href=\"/\">好友列表</a>|\n");
      out.write("                    <a href=\"/\">私人留言</a>|\n");
      out.write("                    <a href=\"/\">信息论坛</a>\n");
      out.write("                </font>      \n");
      out.write("            </td>    \n");
      out.write("        </table>\n");
      out.write("    </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
