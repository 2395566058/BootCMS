package swim.gdkm.poji;

import java.util.Map;

public class Fix {
	private int f_id;
	private String f_repair;
	private String f_info;
	private int f_st_id;
	private int f_user_id;
	private char f_status;
	private int f_st_as_id;
	private String f_time;
	private String f_accomplish;

	public Fix(){
	}
	public Fix(Map map) {
		if(map.get("f_st_id") != null){
			this.f_st_id=(Integer) map.get("f_id");
		}
		if(map.get("f_st_id") != null){
			this.f_st_id=(Integer) map.get("f_st_id");
		}
		if(map.get("f_user_id") != null){
			this.f_user_id=(Integer) map.get("f_user_id");
		}
		if(map.get("f_st_as_id") != null){
			this.f_st_as_id=(Integer) map.get("f_st_as_id");
		}
		if(map.get("f_repair") != null){
			this.f_repair=(String) map.get("f_repair");
		}
		if(map.get("f_info") != null){
			this.f_info=(String) map.get("f_info");
		}
		if(map.get("f_time") != null){
			this.f_time=(String) map.get("f_time");
		}
		if(map.get("f_accomplish") != null){
			this.f_accomplish=(String) map.get("f_accomplish");
		}
		if(map.get("f_status") != null){
			this.f_status=(Character) map.get("f_status");
		}
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_repair() {
		return f_repair;
	}
	public void setF_repair(String f_repair) {
		this.f_repair = f_repair;
	}
	public String getF_info() {
		return f_info;
	}
	public void setF_info(String f_info) {
		this.f_info = f_info;
	}
	public int getF_st_id() {
		return f_st_id;
	}
	public void setF_st_id(int f_st_id) {
		this.f_st_id = f_st_id;
	}
	public int getF_user_id() {
		return f_user_id;
	}
	public void setF_user_id(int f_user_id) {
		this.f_user_id = f_user_id;
	}
	public int getF_status() {
		return f_status;
	}
	public void setF_status(char f_status) {
		this.f_status = f_status;
	}
	public int getF_st_as_id() {
		return f_st_as_id;
	}
	public void setF_st_as_id(int f_st_as_id) {
		this.f_st_as_id = f_st_as_id;
	}
	public String getF_time() {
		return f_time;
	}
	public void setF_time(String f_time) {
		this.f_time = f_time;
	}
	public String getF_accomplish() {
		return f_accomplish;
	}
	public void setF_accomplish(String f_accomplish) {
		this.f_accomplish = f_accomplish;
	}
	@Override
	public String toString() {
		return "Fix [f_id=" + f_id + ", f_repair=" + f_repair + ", f_info="
				+ f_info + ", f_st_id=" + f_st_id + ", f_user_id=" + f_user_id
				+ ", f_status=" + f_status + ", f_st_as_id=" + f_st_as_id
				+ ", f_time=" + f_time + ", f_accomplish=" + f_accomplish + "]";
	}

}
