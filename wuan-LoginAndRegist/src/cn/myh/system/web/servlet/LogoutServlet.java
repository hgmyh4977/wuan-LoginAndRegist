package cn.myh.system.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: ${NAME} <br>
 * date: 2020/8/21 12:23 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
@WebServlet(name = "LogoutServlet",urlPatterns = "/Logout")
public class LogoutServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/jsps/msg.jsp");
    }
}
