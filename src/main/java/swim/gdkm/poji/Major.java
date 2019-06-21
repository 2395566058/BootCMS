package swim.gdkm.poji;

import java.util.Map;

public class Major {
	private int ma_id;
	private String ma_name;
	private int ma_as_id;

	public Major(){
	}
	public Major(Map map) {
		if(map.get("ma_id") != null){
			this.ma_id=(Integer) map.get("ma_id");
		}
		if(map.get("ma_as_id") != null){
			this.ma_as_id=(Integer) map.get("ma_as_id");
		}
		if(map.get("ma_name") != null){
			this.ma_name=(String) map.get("ma_name");
		}
	}
	
	public int getMa_id() {
		return ma_id;
	}
	public void setMa_id(int ma_id) {
		this.ma_id = ma_id;
	}
	public String getMa_name() {
		return ma_name;
	}
	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}
	public int getMa_as_id() {
		return ma_as_id;
	}
	public void setMa_as_id(int ma_as_id) {
		this.ma_as_id = ma_as_id;
	}
	@Override
	public String toString() {
		return "Major [ma_id=" + ma_id + ", ma_name=" + ma_name + ", ma_as_id="
				+ ma_as_id + "]";
	}

}
