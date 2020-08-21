package cn.myh.system.dao;

import cn.myh.system.domain.User;

import java.util.List;

/**
 * description: UserDao <br>
 * date: 2020/8/21 8:53 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
public interface UserDao {
    public void add(User user);
    public void delete(String uid);
    public void update(User user);
    public List<User> findAll();
    public User load(String uid);
    public User findByUsername(String uname);

    public User findByEmail(String email);
}
