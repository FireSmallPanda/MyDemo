package cn.danywer.service.log;

import cn.danywer.dao.log.LogDao;
import cn.danywer.model.common.PageModel;
import cn.danywer.model.log.Log;
import cn.danywer.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;

    @Override
    public Boolean insert(Log var) {
        return logDao.insert(var);
    }

    @Override
    public Boolean delete(Log var) {
        return logDao.delete(var);
    }

    @Override
    public Boolean update(Log var) {
        return logDao.update(var);
    }

    @Override
    public List<Log> select(Log var) {
        return logDao.select(var);
    }

    @Override
    public List<Log> selectByLog(Log log, PageModel page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("log",log);
        map.put("page",page);
        return logDao.selectByLog(map);
    }

    @Override
    public Long selectByLogCount(Log log) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("log",log);
        return logDao.selectByLogCount(map);
    }
}
