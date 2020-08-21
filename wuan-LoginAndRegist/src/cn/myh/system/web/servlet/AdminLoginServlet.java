package cn.myh.system.web.servlet;

import cn.myh.system.domain.User;
import cn.myh.system.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: ${NAME} <br>
 * date: 2020/8/21 14:51 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
@WebServlet(name = "AdminLoginServlet",urlPatterns = "/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
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
        }
        if(form.getPassword() == null || form.getPassword().trim().isEmpty()){
            errors.put("password","密码不能为空");
        }
        if (errors.size()>0){
            request.setAttribute("user",form);
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("/adminjsps/login.jsp").forward(request,response);
            return;
        }
        if(form.getUsername().equals("hgmyh4977") && form.getPassword().equals("443177314")){
            request.getSession().setAttribute("session_admin",form);
            request.getRequestDispatcher("/adminjsps/source/source.jsp").forward(request,response);
            return;
        }else{
            request.setAttribute("msg","管理员用户名/密码错误！");
            request.getRequestDispatcher("/adminjsps/login.jsp").forward(request,response);
            return;
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.findAll();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/adminjsps/source/userlist.jsp").forward(request,response);
    }
}
