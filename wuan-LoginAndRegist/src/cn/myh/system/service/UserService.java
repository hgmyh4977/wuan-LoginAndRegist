package cn.myh.system.service;

import cn.myh.system.dao.UserDao;
import cn.myh.system.dao.UserDaoImpl;
import cn.myh.system.domain.User;

import java.util.List;

/**
 * description: UserService <br>
 * date: 2020/8/21 9:24 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
public class UserService {
    private UserDao userDao = new UserDaoImpl();
    public void regist(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());
        if(user != null){
            throw new UserException("用户名已存在，请重新注册");
        }
        user = userDao.findByEmail(form.getEmail());
        if(user != null){
            throw new UserException("邮箱已存在，请重新注册");
        }
        userDao.add(form);
    }
    public void delete(String uid){
        userDao.delete(uid);
    }
    public void update(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());
        if(!user.getEmail().equals(form.getEmail())){
            user = userDao.findByEmail(form.getEmail());
            if(user != null){
                throw new UserException("邮箱重复，请重新设置！");
            }
        }
        userDao.update(form);
    }
    public User findUser(String uname){
        return userDao.findByUsername(uname);
    }
    public List<User> findAll(){
        return userDao.findAll();
    }

    public User login(User form) throws UserException {
        User user = userDao.findByUsername(form.getUsername());
        if(user ==  null){
            throw new UserException("用户不存在！");
        }else if(!user.getPassword().equals(form.getPassword())){
            throw new UserException("用户密码错误！");
        }
        return user;
    }

}
