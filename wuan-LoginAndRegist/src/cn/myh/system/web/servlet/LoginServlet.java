package cn.myh.system.web.servlet;

import cn.myh.system.domain.User;
import cn.myh.system.service.UserException;
import cn.myh.system.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * description: ${NAME} <br>
 * date: 2020/8/21 9:27 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User form = new User();
        try {
            BeanUtils.populate(form,request.getParameterMap());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Map<String,String> errors = new HashMap<>();
        if(form.getUsername() == null || form.getUsername().trim().isEmpty()){
            errors.put("username","用户名不能为空");
        }else if(form.getUsername().length()<3 || form.getUsername().length()>10){
            errors.put("username","用户名长度为3~10！");
        }
        if(form.getPassword() == null || form.getPassword().trim().isEmpty()){
            errors.put("password","密码不能为空");
        }else if(form.getPassword().length()<3 || form.getPassword().length()>10){
            errors.put("password","密码长度为3~10！");
        }
        if (errors.size()>0){
            request.setAttribute("user",form);
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("/jsps/login.jsp").forward(request,response);
            return;
        }
        User user = null;
        try {
            user = userService.login(form);
        } catch (UserException e) {
            request.setAttribute("user",form);
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/jsps/login.jsp").forward(request,response);
            return;
        }
        request.getSession().setAttribute("session_user",user);
        request.getRequestDispatcher("/jsps/source/source.jsp").forward(request,response);
        return;
    }
}
