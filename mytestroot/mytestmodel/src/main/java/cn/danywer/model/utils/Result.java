package cn.danywer.model.utils;


import cn.danywer.util.PropertiesUtil;

import java.util.Properties;

/**
 * 结果封装
 */
public class Result {
    /**
     * 报错
     *
     * @param code
     */
    public Result(String code) {
        this.code = code;
        this.msg = PropertiesUtil.load("error_CN.properties", code);
        this.state = false;
    }

    public Result(String code, Object data) {
        this.code = code;
        this.data = data;
        this.msg = "请求成功！";
        this.state = true;
    }

    /**
     * 错误码
     */
    private String code;
    /**
     * 提示的信息
     */
    private String msg;

    /**
     * 具体的内容
     */
    private Object data;
    /**
     * 对错状态
     */
    private Boolean state;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
