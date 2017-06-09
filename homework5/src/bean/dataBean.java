package bean;

import java.sql.*;

/**
 * Created by hades on 2017/6/9.
 * 数据库连接及应用Bean
 */
public class dataBean {
    private Connection con;

    public dataBean() {
        String ClassForName = "com.mysql.jdbc.Driver";
        String ServerDB = "jdbc:mysql://localhost:3306/jsp";
        String UserName = "root";
        String PassWord = "root";
        try {
            Class.forName(ClassForName);
            con = DriverManager.getConnection(ServerDB, UserName, PassWord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public ResultSet getData(String username) {
        try {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM list WHERE username = \"" + username + "\"");
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean insertData(String username, String password) throws Exception {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO  list(username,password) VALUES (\"" + username + "\",\"" + password + "\")");
            pstmt.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
