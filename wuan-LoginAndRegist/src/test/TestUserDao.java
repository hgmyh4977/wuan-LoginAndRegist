package test;

import cn.myh.system.dao.UserDao;
import cn.myh.system.dao.UserDaoImpl;
import cn.myh.system.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * description: TestUserDao <br>
 * date: 2020/8/21 9:06 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
public class TestUserDao {
    @Test
    public void testAdd(){
        User user = new User();
        user.setUid("12345");
        user.setUsername("小蓝");
        user.setPassword("11111");
        user.setEmail("4444@qq.com");
        user.setAge(20);
        user.setGender("female");
        UserDao userDao = new UserDaoImpl();
        userDao.add(user);
    }
    @Test
    public void testDelete(){
        UserDao userDao = new UserDaoImpl();
        userDao.delete("1234");
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setUid("1234");
        user.setUsername("myh2112");
        user.setPassword("123");
        user.setEmail("1234@qq.com");
        user.setAge(20);
        user.setGender("male");
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }
    @Test
    public void testLoad(){
        UserDao userDao = new UserDaoImpl();
        User user = userDao.load("1234");
        System.out.println(user);
    }
    @Test
    public void testFindAll(){
        UserDao userDao = new UserDaoImpl();
        List<User> users = userDao.findAll();
        System.out.println(users);
    }
}
