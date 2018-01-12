package cn.danywer.service.log;

import cn.danywer.model.common.PageModel;
import cn.danywer.model.log.Log;
import cn.danywer.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface LogService extends BaseService<Log> {

    /**
     * 根据条件搜索
     * @param log
     * @return
     */
    public List<Log> selectByLog(Log log, PageModel page);


    /**
     * 根据条件搜索(数量)
     * @param log
     * @return
     */
    public Long selectByLogCount(Log log);
}
