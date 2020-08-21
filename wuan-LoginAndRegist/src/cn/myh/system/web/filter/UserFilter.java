package cn.myh.system.web.filter;

import cn.myh.system.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: ${NAME} <br>
 * date: 2020/8/21 11:54 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
@WebFilter(filterName = "UserFilter",urlPatterns = "/jsps/source/*")
public class UserFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        User user = (User)request.getSession().getAttribute("session_user");
        if(user != null) {
            chain.doFilter(req, resp);
        }else{
            request.setAttribute("msg","您还没有登录，无法访问该资源！");
            request.getRequestDispatcher("/jsps/msg.jsp").forward(request,response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
