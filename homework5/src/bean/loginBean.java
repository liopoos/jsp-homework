package bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hades on 2017/6/9.
 * 登录验证Bean
 */
public class loginBean {
    public loginBean() {
    }

    public Boolean checkPassword(String username, String password) throws SQLException {
        dataBean data = new dataBean();
        String password2 = null;
        ResultSet rst = data.getData(username);

        while (rst.next()) {
            password2 = rst.getString("password");
        }
        if (password.equals(password2)) {
            return true;
        } else {
            return false;
        }

    }

}
