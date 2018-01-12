package cn.danywer.dao.log;

import cn.danywer.dao.base.BaseDao;
import cn.danywer.model.common.PageModel;
import cn.danywer.model.log.Log;

import java.util.List;
import java.util.Map;

public interface LogDao extends BaseDao<Log> {
    /**
     * 根据条件搜索
     * @param map
     * @return
     */
    public List<Log> selectByLog(Map<String, Object> map);

    /**
     * 根据条件搜索(数量)
     * @param map
     * @return
     */
    public Long selectByLogCount(Map<String, Object> map);

}
