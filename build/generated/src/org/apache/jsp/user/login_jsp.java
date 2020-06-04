package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");

    String error=(String)request.getAttribute("error");
    String a=(String)request.getAttribute("a");
    String b=(String)request.getAttribute("b");
    String notice=(String)request.getAttribute("notice");
    String c=(String)request.getAttribute("error");

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>登录</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div>\n");
      out.write("            <div>\n");
      out.write("                <h4>请输入账号密码</h4>\n");
      out.write("                <br>              \n");
      out.write("                <form action=\"Check\" >\n");
      out.write("                    账号：<input type=\"text\" name=\"username\"  ");
if(error!=null){
      out.write("value=");
      out.print(a);
}
      out.write(">\n");
      out.write("                    ");
 if(error!=null&&error.equals("账号未输入")){
                        out.print("<font color=red>"+error+"</font>");
                    }
                    
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    密码：<input type=\"text\" name=\"password\"  ");
if(error!=null&&error.equals("邮箱未输入")){
      out.write("value=");
      out.print(b);
}
      out.write(">\n");
      out.write("                    ");
 if(error!=null&&error.equals("密码未输入")){
                        out.print("<font color=red>"+error+"</font>");
                    }
                    
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    邮箱：<input type=\"text\" name=\"email\"  >\n");
      out.write("                    ");
 if(error!=null&&error.equals("邮箱未输入")){
                        out.print("<font color=red>"+error+"</font>");
                    }
                    
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"submit\" value=\"提交\" ><br>\n");
      out.write("                    <a href=\"register.jsp\">注册新用户</a><br>\n");
      out.write("                    ");
 if(notice!= null){ 
      out.write("<font color=\"red\">");
      out.print( notice);
      out.write("</font>");
}
      out.write("\n");
      out.write("                    ");
 if(c!= null){ 
      out.write("<font color=\"red\">");
      out.print( c);
      out.write("</font>");
}
      out.write(" \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div\n");
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
