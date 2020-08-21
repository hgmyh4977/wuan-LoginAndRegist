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
import java.util.UUID;

/**
 * description: ${NAME} <br>
 * date: 2020/8/21 12:35 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
@WebServlet(name = "ModifyServlet",urlPatterns = "/Modify")
public class ModifyServlet extends HttpServlet {
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
        if(form.getPassword() == null || form.getPassword().trim().isEmpty()){
            errors.put("password","密码不能为空");
        }else if(form.getPassword().length()<3 || form.getPassword().length()>10){
            errors.put("password","密码长度为3~10！");
        }
        if(form.getEmail() == null || form.getEmail().trim().isEmpty()){
            errors.put("email","邮箱不能为空");
        }else if(!form.getEmail().matches("\\w+@\\w+\\.\\w+")){
            errors.put("email","邮箱格式错误！");
        }
        if(form.getAge()<0 || form.getAge()>80){
            errors.put("age","您这什么年龄啊？重新输入吧！");
        }
        if (errors.size()>0){
            request.setAttribute("user",form);
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("/jsps/source/modify.jsp").forward(request,response);
            return;
        }
        try {
            userService.update(form);
        } catch (UserException e) {
            request.getSession().setAttribute("session_user",form);
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/jsps/source/modify.jsp").forward(request,response);
            return;
        }
        request.getSession().setAttribute("session_user",form);
        request.setAttribute("msg","修改成功");
        request.getRequestDispatcher("/jsps/msg.jsp").forward(request,response);
        return;

    }
}
