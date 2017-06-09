package bean;

import java.sql.ResultSet;

/**
 * Created by hades on 2017/6/9.
 * 用户注册Bean
 */
public class regBean {
    public regBean() {
    }

    public Boolean addUser(String username, String password) throws Exception {

        try {
            Boolean temp = true;
            dataBean data = new dataBean();
            ResultSet result = data.getData(username);
            while (result.next()) {
                temp = false;
            }
            if (temp) {
                if (data.insertData(username, password)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }

    }

}
