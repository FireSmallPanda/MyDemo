package cn.danywer.service.user;

import cn.danywer.dao.user.UserDao;
import cn.danywer.model.user.User;
import cn.danywer.model.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Boolean addUser(User User) {
        return null;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return null;
    }

    @Override
    public Boolean updateUserById(User user) {
        return null;
    }

    @Override
    public List<User> findAllUser(User user) {
        List<User> list = userDao.select(user);
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
