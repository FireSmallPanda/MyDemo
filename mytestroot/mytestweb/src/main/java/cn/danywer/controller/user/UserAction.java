package cn.danywer.controller.user;

import cn.danywer.model.Student;
import cn.danywer.model.log.Log;
import cn.danywer.model.user.User;
import cn.danywer.model.utils.Result;
import cn.danywer.model.utils.ResultVo;
import cn.danywer.service.log.LogService;
import cn.danywer.service.user.UserService;
import cn.danywer.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserAction {

    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;
    /**
     * 登录操作 （U1）
     *
     * @param user
     * @return
     */
    @RequestMapping("userLogin")
    @ResponseBody
    public Result userLogin(User user, HttpServletRequest request) {
        // 搜索用户
        User searchUser  = new User();
        searchUser.setAccount(user.getAccount());
        List<User> retnList = userService.findAllUser(searchUser);
        User loginUser = null;// 数据库存储的用户对象
        if (retnList != null) {// 判断用户是否注册
            loginUser = retnList.get(0);// 将查询出来的用户赋值
        } else {
            return new Result("US0001");
        }
        if (!loginUser.getPassword().equals(user.getPassword())) { // 判断密码是否正确

            return new Result("US0001");
        }
        // 去除查询到的密码
        loginUser.setPassword("");

        // 记录日志
        Log log = new Log();
        log.setAction("1");
        log.setAction_time(new Date());
        log.setStatus("1");
        log.setUser_id(loginUser.getId());
        log.setIp(CommonUtil.getIpAddr(request));
        logService.insert(log);

        // 更改登录本人信息
        loginUser.setIp(CommonUtil.getIpAddr(request));
        loginUser.setLast_login_time(new Date());
        userService.updateUserById(loginUser);


        // 登录信息保存session
        HttpSession session = request.getSession();
        session.setAttribute("loginUser",loginUser);


        // 返回对象
        Map<String, Object> retn = new HashMap<String, Object>();
        retn.put("loginUser",loginUser);
        // 返回正确
        return new Result("SY0000", retn);


    }
}
