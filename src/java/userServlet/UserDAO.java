package userServlet;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseAccess;

public class UserDAO {
//判断数据库中是否存在用户名

    public boolean isExist(String username) {
        boolean isExist = false;
        DatabaseAccess db = new DatabaseAccess();
        String sql = "select * from user where username='" + username + "'";
        db.query(sql);
        if (db.isHaveResult(sql)) {
            isExist = true;
        }

        db.close();

        return isExist;
    }

    //判断用户名的对应密码是否正确
    //现在不用此方法，因为密码填（1'or'1'='1）括号里内容，总是可登陆
    public boolean isValid(String username, String password) {
        boolean isValid = false;
        DatabaseAccess db = new DatabaseAccess();
        String sql = "select * from user where username='" + username + "' and password='" + password + "'";
        db.query(sql);

        if (db.isHaveResult(sql)) {
            isValid = true;
        }
        db.close();

        return isValid;
    }

//新增一个用户到数据库
    public void add(String username, String password, String email) {
        DatabaseAccess db = new DatabaseAccess();

        String sql = "insert into user(username,password,email) values('" + username + "','" + password + "','" + email + "')";
        db.update(sql);
        db.close();
    }
    
        //改变用户名为username的这条数据field字段值为value

    public void update(String field, String value, String username) {
        DatabaseAccess db = new DatabaseAccess();
        String sql = "update user set " + field + " ='" + value + "'where username='" + username + "'";
        db.update(sql);
        db.close();
    }
    
    
//
    public UserBean getOne(String username) {
        DatabaseAccess db = new DatabaseAccess();
        UserBean user = new UserBean();
        String sql = "select * from user where username='" + username + "'";

        try {
            ResultSet rs = db.query(sql);
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getString("birthday"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setPersonnal(rs.getString("personal"));
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {

            db.close();
        }

        return user;

    }
        public List getAll() {
        DatabaseAccess db = new DatabaseAccess();
        ResultSet rs = null;
        List usersList = new ArrayList();

        String sql = "select * from user order by id";

        try {
            rs = db.query(sql);
            while (rs.next()) {
                UserBean user = new UserBean();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setPersonnal(rs.getString("personal"));

                usersList.add(user);
                user = null;

            }
              if (rs != null) {
                    rs.close();
                }

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            // 关闭连接，释放数据库资源：
         
                db.close();
     
        }

        return usersList;

    }
}
