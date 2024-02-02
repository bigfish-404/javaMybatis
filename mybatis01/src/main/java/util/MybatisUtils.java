package util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//写好不用动
//sqlSessionFactory-->aqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //从xml中构建sqlSessionFactory
            //sqlSessionFactory负责创建sqlSession
            //链接核心配置文件，配置文件的路径
            String resource = "mybatis-config.xml";
            //使用mybatis提供的Resource类的静态方法getResourceAsStream获得在resource（核心配置文件）路径下的资源流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //上面获得资源流后传给sqlSessionFactory（）调用他的Build（）方法
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
//SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。而 SqlSessionFactoryBuilder
// 则可以从 XML 配置文件或一个预先配置的 Configuration 实例来构建出 SqlSessionFactory 实例。
//    获得SqlSession的链接
//    通过调用sqlSessionFactory使用openSession（）方法创建一个sqlSession
    public static SqlSession getSqlSession(){
       return sqlSessionFactory.openSession();
    }
}
