package cn.danywer.model.user;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： u_user <br/>
 *         描述：u_user <br/>
 */
@SuppressWarnings("serial")
public class User implements Serializable {
    protected Long id;// id
    protected String account;// 姓名
    protected String password;// password
    protected String ip;// ip
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    protected Date last_login_time;// last_login_time
    protected String status;// 状态

    public User() {
        super();
    }

    public User(Long id) {
        super();
        this.id = id;
    }

    @Id// 主键
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }
    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
