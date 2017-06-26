/**
 * Created by hades on 2017/5/10.
 * 注册验证
 */

import bean.regBean;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegCheck extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        regBean add = new regBean();
        if (password.equals(password2)) {
            try {
                if (add.addUser(username, password)) {
                    response.sendRedirect("reg-success.jsp?username=" + username + "&password=" + password);
                } else {
                    response.sendRedirect("reg-fail.jsp?e=1");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            response.sendRedirect("reg-fail.jsp?e=2");
        }

    }

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        doPost(rq, rs);

    }
}