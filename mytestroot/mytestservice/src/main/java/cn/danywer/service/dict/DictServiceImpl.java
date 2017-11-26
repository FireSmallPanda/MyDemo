package cn.danywer.service.dict;

import cn.danywer.dao.dict.DictDao;
import cn.danywer.model.dict.Dict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DictServiceImpl implements DictService {
   @Resource
   private DictDao dictDao;


    @Override
    public Boolean insert(Dict var) {
        return dictDao.insert(var);
    }

    @Override
    public Boolean delete(Dict var) {
        return dictDao.delete(var);
    }

    @Override
    public Boolean update(Dict var) {
        return dictDao.update(var);
    }

    @Override
    public List<Dict> select(Dict var) {
        return dictDao.select(var);
    }

    @Override
    public List<Dict> selectAll() {
        return dictDao.selectAll();
    }
}
