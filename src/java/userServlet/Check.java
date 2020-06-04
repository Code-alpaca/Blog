package userServlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Check", urlPatterns = {"/Check"})
public class Check extends HttpServlet {

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
        String name=request.getParameter("username");
        String mima=request.getParameter("password");
        String youxiang=request.getParameter("email");
        HttpSession session=request.getSession(); 
        session.setAttribute("username",name);
        if(name.equals("")){
            request.setAttribute("error","账号未输入" );
            request.getRequestDispatcher("user/login.jsp").forward(request, response);
        }
        else if(mima.equals("")){
            request.setAttribute("error","密码未输入" );
            request.setAttribute("a",name );
            request.getRequestDispatcher("user/login.jsp").forward(request, response);
        } 
        else if(youxiang.equals("")){
            request.setAttribute("error","邮箱未输入" );
            request.setAttribute("a",name );
            request.setAttribute("b",mima );
            request.getRequestDispatcher("user/login.jsp").forward(request, response);
        }else{
           
        

            String drv = "com.mysql.jdbc.Driver";//数据库驱动类
            String url = "jdbc:mysql://localhost:3306/j";//数据库地址
            String usr = "root";
            String pwd = "123456";

            //String sql = "select username from user where id=1";
            String sql =null;
            
            
            Connection conn = null;
            Statement stm = null;
            ResultSet rs = null;

            try {
                Class.forName(drv);//加载数据库驱动程序
                conn = DriverManager.getConnection(url, usr, pwd);//连接数据库

                stm = conn.createStatement();//创建连接状态

                sql = "select * from user where username='" + name + "'and password='"+mima+"'and email='"+youxiang+"'";
                rs = stm.executeQuery(sql);//执行查询，结果保存在rs
                if(rs.next()){
                   
                    request.setAttribute("name", name);
                    request.getRequestDispatcher("user/welcome.jsp").forward(request, response);    
                }
                else{
                    request.setAttribute("error", "填写信息错误！");
                    request.getRequestDispatcher("user/login.jsp").forward(request, response);
                }


            } catch (Exception e) {
                System.out.println("at Check");
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
                    System.out.println("at Check");
                    System.out.println(ex);
                }
                System.out.println("程序执行到最后！");
            }
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
