package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

//接口
public interface UserMapper {//等价于mapper
    //获取全部用户
    List<User> getUserList();

    //根据id查询用户Retrieve
    User getUserById(int id);

    //insert一个用户Create
    void addUser(User user);

    //根据密码和用户名查询
    User selectUserByNp(Map<String,String> map);

    //改 Update
    void updateUser(User user);

    //删除Delete
    void deleteUser(int id);
}
