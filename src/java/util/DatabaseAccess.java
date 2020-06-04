package util;

import java.sql.*;

/**
 *
 * @author e
 */
public class DatabaseAccess {

    private String drv = "com.mysql.jdbc.Driver";//数据库驱动类
    private String url = "jdbc:mysql://localhost:3306/j";//数据库地址
    private String usr = "root";
    private String pwd = "123456";
    
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;

    public DatabaseAccess() {
        try {
            Class.forName(drv);
            conn = DriverManager.getConnection(url, usr, pwd);
            stm = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean update(String sql) {
        boolean b = false;
        try {
            stm.executeUpdate(sql);
            b = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }

    public ResultSet query(String sql) {
        try {
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rs;
    }

    public boolean isHaveResult(String sql) {
        boolean b = false;
        try {
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                b = true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return b;
    }

    public void close() {
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
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
