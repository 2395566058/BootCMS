package swim.gdkm.poji;

import java.util.Date;

public class Schedule {
	private int sc_id;
	private String sc_name;
	private Date sc_start;
	private Date sc_end;
	private String sc_week;
	private Date sc_time;
	private String sc_classroom;
	public int getSc_id() {
		return sc_id;
	}
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	public Date getSc_start() {
		return sc_start;
	}
	public void setSc_start(Date sc_start) {
		this.sc_start = sc_start;
	}
	public Date getSc_end() {
		return sc_end;
	}
	public void setSc_end(Date sc_end) {
		this.sc_end = sc_end;
	}
	public String getSc_week() {
		return sc_week;
	}
	public void setSc_week(String sc_week) {
		this.sc_week = sc_week;
	}
	public Date getSc_time() {
		return sc_time;
	}
	public void setSc_time(Date sc_time) {
		this.sc_time = sc_time;
	}
	public String getSc_classroom() {
		return sc_classroom;
	}
	public void setSc_classroom(String sc_classroom) {
		this.sc_classroom = sc_classroom;
	}
	public int getSc_user_id() {
		return sc_user_id;
	}
	public void setSc_user_id(int sc_user_id) {
		this.sc_user_id = sc_user_id;
	}
	private int sc_user_id;
	@Override
	public String toString() {
		return "Schedule [sc_id=" + sc_id + ", sc_name=" + sc_name
				+ ", sc_start=" + sc_start + ", sc_end=" + sc_end
				+ ", sc_week=" + sc_week + ", sc_time=" + sc_time
				+ ", sc_classroom=" + sc_classroom + ", sc_user_id="
				+ sc_user_id + "]";
	}
	

}
