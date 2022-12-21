package cn.fvti.core.service;

import cn.fvti.core.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public User findUser(String usercode,String password);
    public int user_sign(User user);
}
