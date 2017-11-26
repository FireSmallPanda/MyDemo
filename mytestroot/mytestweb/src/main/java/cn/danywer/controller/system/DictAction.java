package cn.danywer.controller.system;

import cn.danywer.entity.RedisReq;
import cn.danywer.model.dict.Dict;
import cn.danywer.model.utils.Result;
import cn.danywer.service.dict.DictService;
import cn.danywer.util.CookieUtil;
import cn.danywer.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/system")
public class DictAction {

    @Autowired
    private DictService dictService;

    /**
     * 载入所有字典(S1)
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/loadAllDict")
    @ResponseBody
    public Result loadAllDict(HttpServletRequest request, HttpServletResponse response) {
       List<Dict> list = dictService.selectAll();
        return new Result("SY0000", list);
    }


}
