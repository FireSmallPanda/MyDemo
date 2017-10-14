package cn.danywer.service.user;

import cn.danywer.model.user.User;
import cn.danywer.model.utils.ResultVo;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     * @param User
     * @return
     */
    Boolean addUser(User User);

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    Boolean deleteUserById(Integer id);

    /**
     * 根据ID修改用户信息
     * @param user
     * @return
     */
    Boolean updateUserById(User user);

    /**
     * 按条件查找所有用户
     * @param user
     * @return
     */
//修改之处
    List<User> findAllUser(User user);


}
