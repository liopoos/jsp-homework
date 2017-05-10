/**
 * Created by hades on 2017/5/10.
 */

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
        if (password.equals(password2)) {
            response.sendRedirect("reg-success.jsp?username=" + username + "&password=" + password);
        } else {
            response.sendRedirect("reg-fail.jsp");
        }

    }

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        doPost(rq, rs);

    }
}