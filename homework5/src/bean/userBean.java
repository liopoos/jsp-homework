package bean;

/**
 * Created by hades on 2017/5/10.
 * 用户实体Bean
 */
public class userBean {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String sayHello() {
        return "Hello!";
    }
}
