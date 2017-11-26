package cn.danywer.service.dict;

import cn.danywer.model.dict.Dict;
import cn.danywer.service.base.BaseService;

import java.util.List;

public interface DictService extends BaseService<Dict>  {

    /**
     * 获取全部字典
     * @return
     */
    public List<Dict> selectAll();

}
