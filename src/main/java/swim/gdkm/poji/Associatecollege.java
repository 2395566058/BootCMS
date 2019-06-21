package swim.gdkm.poji;

import java.util.Map;

public class Associatecollege {
	private int as_id;
	private String as_name;
	public Associatecollege(){
		}
	public Associatecollege(Map map) {
		if(map.get("as_id") != null){
			this.as_id=(Integer) map.get("as_id");
		}
		if(map.get("as_name") != null){
			this.as_name=(String) map.get("as_name");
		}
	}
	public int getAs_id() {
		return as_id;
	}
	public void setAs_id(int as_id) {
		this.as_id = as_id;
	}
	public String getAs_name() {
		return as_name;
	}
	public void setAs_name(String as_name) {
		this.as_name = as_name;
	}
	@Override
	public String toString() {
		return "Associatecollege [as_id=" + as_id + ", as_name=" + as_name
				+ "]";
	}

}
