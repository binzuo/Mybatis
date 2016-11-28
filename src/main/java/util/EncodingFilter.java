package util;
//项目包>src>main>java>创建的util>过滤器类 EncodingFilter.


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    //接口Filter:javax.servlet.

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
