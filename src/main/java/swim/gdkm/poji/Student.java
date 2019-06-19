package swim.gdkm.poji;

import java.util.Date;

public class Student {
	private int st_id;
	private String st_name;
	private int st_user_id;
	private int st_as_id;
	private int st_ma_id;
	private Date st_admissiondate;
	private int st_phone;
	private String st_address;
	private Date st_registerdate;
	private Date st_born;
	private char st_sex;
	private String st_sc;
	private String st_image;

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

	public Date getSt_admissiondate() {
		return st_admissiondate;
	}

	public void setSt_admissiondate(Date st_admissiondate) {
		this.st_admissiondate = st_admissiondate;
	}

	public int getSt_phone() {
		return st_phone;
	}

	public void setSt_phone(int st_phone) {
		this.st_phone = st_phone;
	}

	public String getSt_address() {
		return st_address;
	}

	public void setSt_address(String st_address) {
		this.st_address = st_address;
	}

	public Date getSt_registerdate() {
		return st_registerdate;
	}

	public void setSt_registerdate(Date st_registerdate) {
		this.st_registerdate = st_registerdate;
	}

	public Date getSt_born() {
		return st_born;
	}

	public void setSt_born(Date st_born) {
		this.st_born = st_born;
	}

	public int getSt_sex() {
		return st_sex;
	}

	public void setSt_sex(char st_sex) {
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
