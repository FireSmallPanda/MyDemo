package cn.danywer.service.base;

import java.util.List;

public interface BaseService<T> {

    public Boolean insert(T var);

    public Boolean delete(T var);

    public Boolean update(T var);

    public List<T> select(T var);

}
