package cn.danywer.model.utils;

/**
 * Redis对象
 */
public class RedisReq {
    /**
     * key键
     */
    private String key;
    /**
     * field类
     */
    private String field;
    /**
     * 存储的对象
     */
    private Object o;

    /**
     * 时间过期类型
     */
    private  String timeFlag;




    public String getKey() {
        return key;
    }

    public String getTimeFlag() {
        return timeFlag;
    }

    public void setTimeFlag(String timeFlag) {
        this.timeFlag = timeFlag;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
}
