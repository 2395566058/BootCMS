package swim.gdkm.poji;

public class Sysuser {
	private int user_id;
	private String user_code;
	private String user_name;
	private String user_passowrd;
	private String user_state;
	private int user_as_id;
	private String user_authorization;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
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
	public String getUser_passowrd() {
		return user_passowrd;
	}
	public void setUser_passowrd(String user_passowrd) {
		this.user_passowrd = user_passowrd;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public int getUser_as_id() {
		return user_as_id;
	}
	public void setUser_as_id(int user_associatecollege_id) {
		this.user_as_id = user_associatecollege_id;
	}
	public String getUser_authorization() {
		return user_authorization;
	}
	public void setUser_authorization(String user_authorization) {
		this.user_authorization = user_authorization;
	}
	@Override
	public String toString() {
		return "Sysuser [user_id=" + user_id + ", user_code=" + user_code
				+ ", user_name=" + user_name + ", user_passowrd="
				+ user_passowrd + ", user_state=" + user_state
				+ ", user_associatecollege_id=" + user_as_id
				+ ", user_authorization=" + user_authorization + "]";
	}

}
