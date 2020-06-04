/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userServlet;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DatabaseAccess;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");

        if (method == null) {
        } else if (method.equals("show")) {
            //在显示用户资料页面前查询数据库
            show(request, response);
        } else if (method.equals("edit")) {
            //在更新用户资料页面前查询数据库
            edit(request, response);
        } else if (method.equals("update")) {
            //提交更新用户资料后更新数据库
            update(request, response);
        } 

    }

    protected void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("username");

        if (username == null) {
            request.setAttribute("notice", "请先登录！");
            request.setAttribute("gotoPath", "UserServlet?method=show");
            request.getRequestDispatcher("user/login.jsp").forward(request, response);
        } else {
            UserDAO userDao = new UserDAO();
            UserBean user = userDao.getOne(username);
            request.setAttribute("username",user.getUsername());
            request.setAttribute("password",user.getPassword());
            request.setAttribute("email",user.getEmail());
            request.setAttribute("gender",user.getGender());
            request.setAttribute("birthday",user.getBirthday());
            request.setAttribute("phone",user.getPhone());
            request.setAttribute("address",user.getAddress());
            request.setAttribute("personnal",user.getPersonnal());
            request.getRequestDispatcher("user/show.jsp").forward(request, response);
        }
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("username");
        if (username == null){
            request.getRequestDispatcher("user/login.jsp").forward(request, response);
        
        }else{
            DatabaseAccess db=new DatabaseAccess();
            ResultSet rs = db.query("select * from user where username='" + username + "'");
            request.setAttribute("rs", rs);
            request.getRequestDispatcher("user/edit.jsp").forward(request, response);
        
        }
  
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            request.setAttribute("notice", "请先登录！");
            request.getRequestDispatcher("user/login.jsp").forward(request, response);
        } else {

            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String personal = request.getParameter("personal");

            UserDAO userDao = new UserDAO();

            if (email != null) {
                userDao.update("email", email, username);
            }
            if (gender != null) {
                userDao.update("gender", gender, username);
            }
            if (birthday != null) {
                userDao.update("birthday", birthday, username);
            }
            if (phone != null) {
                userDao.update("phone", phone, username);
            }
            if (address != null) {
                userDao.update("address", address, username);
            }
            if (personal != null) {
                userDao.update("personal", personal, username);
            }
            
            response.sendRedirect("UserServlet?method=show");
        }
    }


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
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
