/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author e
 */
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");

//判断是否为空
        if (username.equals("") || password1.equals("") || password2.equals("")) {
            request.setAttribute("notice", "信息未输入完整");
            request.getRequestDispatcher("user/register.jsp").forward(request, response);
//两次密码是否相同  
        } else if (!password1.equals(password2)) {

            request.setAttribute("notice", "两次输入密码不同");
            request.getRequestDispatcher("user/register.jsp").forward(request, response);
//用户名是否已注册
        } else {

            String drv = "com.mysql.jdbc.Driver";
            //  String url = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=d:\\j.mdb";
            String url = "jdbc:mysql://localhost:3306/j";
            String usr = "root";
            String pwd = "123456";
            boolean isValid = false;
            String sql = "select * from user where username='" + username + "'";

            Connection conn = null;
            Statement stm = null;
            ResultSet rs = null;

            try {
                Class.forName(drv);
                conn = DriverManager.getConnection(url, usr, pwd);

                stm = conn.createStatement();
                rs = stm.executeQuery(sql);
                if (!rs.next()) {
                    sql = "insert into user(username,password,email) values('" + username + "','" + password1+ "','" + email + "')";
                    stm.executeUpdate(sql);
                    isValid = true;
                }

                rs.close();
                stm.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("at RegisterServlet1");
                System.out.println(e);
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stm != null) {
                        stm.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (Exception ex) {
                    System.out.println("at RegisterServlet2");
                    System.out.println(ex);
                }
            }

            if (isValid) {
                request.setAttribute("notice", "注册成功！请登录。");
                request.getRequestDispatcher("user/login.jsp").forward(request, response);
            } else {
                request.setAttribute("notice", "用户名已注册，请更换用户名");
                request.getRequestDispatcher("user/register.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet 方法。单击左侧的 + 号以编辑代码。">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
