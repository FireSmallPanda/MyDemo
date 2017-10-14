package cn.danywer.model.log;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： s_log <br/>
 *         描述：s_log <br/>
 */
@SuppressWarnings("serial")
public class Log implements Serializable {
	protected Long id;// id
	protected String ip;// 操作ip
	protected Long user_id;// 用户id
	protected String action;// 抄作内容
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	protected Date action_time;// 操作时间
	protected String status;// 状态

	public Log() {
		super();
	}

	public Log(Long id) {
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
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public Date getAction_time() {
		return action_time;
	}
	public void setAction_time(Date action_time) {
		this.action_time = action_time;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
