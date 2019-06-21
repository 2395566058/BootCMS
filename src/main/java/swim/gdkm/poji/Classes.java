package swim.gdkm.poji;

import java.util.Map;

public class Classes {
	private int cl_id;
	private String cl_name;
	public Classes(){
	}
	public Classes(Map map) {
		if(map.get("cl_id") != null){
			this.cl_id=(Integer) map.get("cl_id");
		}
		if(map.get("cl_name") != null){
			this.cl_name=(String) map.get("cl_name");
		}
	
}
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	@Override
	public String toString() {
		return "Classes [cl_id=" + cl_id + ", cl_name=" + cl_name + "]";
	}
	

}
