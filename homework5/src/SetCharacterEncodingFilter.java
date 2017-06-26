/**
 * Created by hades on 2017/5/10.
 * 设置过滤器
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SetCharacterEncodingFilter implements Filter {
    protected String encoding = "UTF_8";
    protected FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");

    }

    public void destroy() {
        this.encoding = null;

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest res = (HttpServletRequest) request;
        res.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }


}