package cn.danywer.dao.dict;

import cn.danywer.dao.base.BaseDao;
import cn.danywer.model.dict.Dict;

import java.util.List;

public interface DictDao  extends BaseDao<Dict> {
    /**
     * 获取全部字典
      * @return
     */
    public List<Dict> selectAll();


}
