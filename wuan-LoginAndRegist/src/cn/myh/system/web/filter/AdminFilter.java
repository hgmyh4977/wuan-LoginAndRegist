package cn.myh.system.web.filter;

import cn.myh.system.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: ${NAME} <br>
 * date: 2020/8/21 15:09 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
@WebFilter(filterName = "AdminFilter",urlPatterns = "/adminjsps/source/*")
public class AdminFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        User admin = (User) request.getSession().getAttribute("session_admin");
        if(admin != null){
            chain.doFilter(req, resp);
        }else{
            request.getRequestDispatcher("/jsps/login.jsp").forward(request,response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
