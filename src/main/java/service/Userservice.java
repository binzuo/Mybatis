package service;

import Model.User;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSession;

/**
 * Created by Administrator on 2016/11/27.
 */
public class Userservice {
    // create record by XML configuration
    private static int createUserViaXML() {//推荐使用
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            return sqlSession.insert("user.create", new Model.User(null,"email","password"));
        }
    }

    // create record by Mapper interface
    private static int createUser() {//需要多做一个接口。
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.create(new User(null, "Tester2", "password2"));

        }
    }

    public static void main(String[] args) {
        createUserViaXML(); // MyBatis method 1
        //createUser(); // MyBatis method 2: Type Safer
    }
}
