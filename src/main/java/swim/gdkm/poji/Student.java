package swim.gdkm.poji;

import java.util.Date;
import java.util.Map;

public class Student {
	private int st_id;
	private String st_name;
	private int st_user_id;
	private int st_as_id;
	private int st_ma_id;
	private String st_admissiondate;
	private String st_phone;
	private String st_address;
	private String st_registerdate;
	private String st_born;
	private String st_sex;
	private String st_sc;
	private String st_image;

	public Student() {

	}

	public Student(Map map) {
		if (map.get("st_address") != null) {
			this.st_address = (String) map.get("st_address");
		}
		if (map.get("st_name") != null) {
			this.st_name = (String) map.get("st_name");
		}
		if (map.get("st_sc") != null) {
			this.st_sc = (String) map.get("st_sc");
		}
		if (map.get("st_image") != null) {
			this.st_image = (String) map.get("st_image");
		}
		if (map.get("st_admissiondate") != null) {
			this.st_admissiondate = (String) map.get("st_admissiondate");
		}
		if (map.get("st_registerdate") != null) {
			this.st_registerdate = (String) map.get("st_registerdate");
		}
		if (map.get("st_born") != null) {
			this.st_born = (String) map.get("st_born");
		}
		if (map.get("st_id") != null) {
			this.st_id = (Integer) map.get("st_id");
		}
		if (map.get("st_user_id") != null) {
			this.st_user_id = (Integer) map.get("st_user_id");
		}
		if (map.get("st_as_id") != null) {
			this.st_as_id = (Integer) map.get("st_as_id");
		}
		if (map.get("st_ma_id") != null) {
			this.st_ma_id = (Integer) map.get("st_ma_id");
		}
		if (map.get("st_phone") != null) {
			this.st_phone = (String) map.get("st_phone");
		}
		if (map.get("st_sex") != null) {
			this.st_sex = (String) map.get("st_sex");
		}
	}

	public int getSt_id() {
		return st_id;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public int getSt_user_id() {
		return st_user_id;
	}

	public void setSt_user_id(int st_user_id) {
		this.st_user_id = st_user_id;
	}

	public int getSt_as_id() {
		return st_as_id;
	}

	public void setSt_as_id(int st_as_id) {
		this.st_as_id = st_as_id;
	}

	public int getSt_ma_id() {
		return st_ma_id;
	}

	public void setSt_ma_id(int st_ma_id) {
		this.st_ma_id = st_ma_id;
	}

	public String getSt_admissiondate() {
		return st_admissiondate;
	}

	public void setSt_admissiondate(String st_admissiondate) {
		this.st_admissiondate = st_admissiondate;
	}

	public String getSt_phone() {
		return st_phone;
	}

	public void setSt_phone(String st_phone) {
		this.st_phone = st_phone;
	}

	public String getSt_address() {
		return st_address;
	}

	public void setSt_address(String st_address) {
		this.st_address = st_address;
	}

	public String getSt_registerdate() {
		return st_registerdate;
	}

	public void setSt_registerdate(String st_registerdate) {
		this.st_registerdate = st_registerdate;
	}

	public String getSt_born() {
		return st_born;
	}

	public void setSt_born(String st_born) {
		this.st_born = st_born;
	}

	public String getSt_sex() {
		return st_sex;
	}

	public void setSt_sex(String st_sex) {
		this.st_sex = st_sex;
	}

	public String getSt_sc() {
		return st_sc;
	}

	public void setSt_sc(String st_sc) {
		this.st_sc = st_sc;
	}

	@Override
	public String toString() {
		return "Student [st_id=" + st_id + ", st_name=" + st_name + ", st_user_id=" + st_user_id + ", st_as_id="
				+ st_as_id + ", st_ma_id=" + st_ma_id + ", st_admissiondate=" + st_admissiondate + ", st_phone="
				+ st_phone + ", st_address=" + st_address + ", st_registerdate=" + st_registerdate + ", st_born="
				+ st_born + ", st_sex=" + st_sex + ", st_sc=" + st_sc + "]";
	}

	public String getSt_image() {
		return st_image;
	}

	public void setSt_image(String st_image) {
		this.st_image = st_image;
	}

}
