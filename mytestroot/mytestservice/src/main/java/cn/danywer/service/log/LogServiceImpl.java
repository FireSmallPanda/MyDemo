package cn.danywer.service.log;

import cn.danywer.dao.log.LogDao;
import cn.danywer.model.log.Log;
import cn.danywer.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
        return null;
    }

    @Override
    public Boolean update(Log var) {
        return null;
    }

    @Override
    public List<Log> select(Log var) {
        return null;
    }
}
