package cn.fvti.core.service;

import cn.fvti.core.dao.UserDao;
import cn.fvti.core.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServicelmpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String usercode, String password) {
        User user = this.userDao.findUser(usercode,password);
        return user;
    }

    public int user_sign(User user){
        return this.userDao.user_sign(user);
    }

}
