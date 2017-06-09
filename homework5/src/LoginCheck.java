/**
 * Created by hades on 2017/5/10.
 */

import bean.loginBean;
import bean.userBean;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginCheck extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userBean user = new userBean();
        user.setUsername(username);
        user.setPassword(password);
        loginBean check = new loginBean();
        try {
            if (check.checkPassword(user.getUsername(), user.getPassword())) {
                response.sendRedirect("login-success.jsp");
            } else {
                response.sendRedirect("login-fail.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        doPost(rq, rs);

    }
}