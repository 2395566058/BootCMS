package swim.gdkm.poji;

import java.io.Serializable;

/*
 *	系统用户表 
 */

public class Sys_user implements Serializable {
	private static final long serialVersionUID = 1L;
	private int Field;// Comment
	private String user_id;// 用户id
	private String user_code;// 用户账号
	private String user_name;// 用户名称
	private String user_password;// 用户密码
	private String user_state;// 用户状态(1:正常,0:暂停)

	public int getField() {
		return Field;
	}

	public void setField(int field) {
		Field = field;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
