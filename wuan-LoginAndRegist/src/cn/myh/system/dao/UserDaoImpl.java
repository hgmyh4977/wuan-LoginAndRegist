package cn.myh.system.dao;

import cn.myh.system.domain.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * description: UserDaoImpl <br>
 * date: 2020/8/21 9:01 <br>
 * author: myh <br>
 * version: 1.0 <br>
 */
public class UserDaoImpl implements UserDao{
    private QueryRunner qr;
    public UserDaoImpl(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        this.qr = new QueryRunner(dataSource);
    }
    @Override
    public void add(User user) {
        String sql = "insert into t_user values(?,?,?,?,?,?)";
        Object[] params = new Object[]{user.getUid(),user.getUsername(),user.getPassword(),
                user.getEmail(),user.getAge(),user.getGender()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String uid) {
        String sql = "delete from t_user where uid=?";
        try {
            qr.update(sql,uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String sql = "update t_user set username=?,password=?,email=?,age=?,gender=? where uid=?";
        Object[] params = new Object[]{user.getUsername(),user.getPassword(),
                user.getEmail(),user.getAge(),user.getGender(),user.getUid()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from t_user";
        try {
            return qr.query(sql,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User load(String uid) {
        String sql = "select * from t_user where uid=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUsername(String uname) {
        String sql = "select * from t_user where username=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),uname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByEmail(String email) {
        String sql = "select * from t_user where email=?";
        try {
            return qr.query(sql,new BeanHandler<User>(User.class),email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
