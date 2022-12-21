package cn.fvti.core.dao;

import cn.fvti.core.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public User findUser(@Param("usercode") String usercode,
                         @Param("password") String passwoed);

    public int user_sign (User user);

}
