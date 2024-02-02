package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import util.MybatisUtils;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //获得sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行,调用getMapper方法装入UserMapper这个类
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for(User user:userList){
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession =MybatisUtils.getSqlSession();

        //下面相当于UserMapper mapper =new UserMappeIml();
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    //测试insert
    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.addUser(new User(5,"akj","1245"));

        //增删改查都需要提交事物,否则不成功
        sqlSession.commit();

        sqlSession.close();
    }

    //根据用户名和密码选择用户
    @Test
    public void selectUserByNpTest(){
        //利用工具类得到session对象
        SqlSession session = MybatisUtils.getSqlSession();
        //然后利用该方法得到mapper对象
        UserMapper mapper =session.getMapper(UserMapper.class);
        //建立一个Map对象用于存放名称与密码
        HashMap<String ,String> hashMap =new HashMap<>();
        hashMap.put("name","akj");
        hashMap.put("pwd","1245");
        //直接利用mapper方法
        User user = mapper.selectUserByNp(hashMap);
        System.out.println(user);
        session.close();
    }

    //修改 update
    @Test
    public void updateUserTest(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User newUser = new User(5,"haha","1245");
        userMapper.updateUser(newUser);
        session.commit();
        session.close();
    }
    //删除 delete
    @Test
    public void deleteUserTest(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        userMapper.deleteUser(5);
        session.close();
    }
}
