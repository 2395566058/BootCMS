package swim.gdkm.poji;

import java.io.Serializable;

/*
 *	系统用户表
 */

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int Field;// Comment
	private String cust_id;// 客户编号
	private int cust_name;// 客户名称
	private int cust_user_id;// 负责人id
	private String cust_create_id;// 创建人id
	private String cust_source;// 客户信息来源
	private String cust_industry;// 客户所属行业
	private String cust_level;// 客户级别
	private String cust_linkman;// 联系人
	private String cust_phone;// 固定电话
	private String cust_mobile;// 移动电话
	private String cust_zipcode;// 邮政编码
	private String cust_address;// 联系地址
	private String cust_createtime;// 创建时间

	public int getField() {
		return Field;
	}

	public void setField(int field) {
		Field = field;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public int getCust_name() {
		return cust_name;
	}

	public void setCust_name(int cust_name) {
		this.cust_name = cust_name;
	}

	public int getCust_user_id() {
		return cust_user_id;
	}

	public void setCust_user_id(int cust_user_id) {
		this.cust_user_id = cust_user_id;
	}

	public String getCust_create_id() {
		return cust_create_id;
	}

	public void setCust_create_id(String cust_create_id) {
		this.cust_create_id = cust_create_id;
	}

	public String getCust_source() {
		return cust_source;
	}

	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}

	public String getCust_industry() {
		return cust_industry;
	}

	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}

	public String getCust_level() {
		return cust_level;
	}

	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}

	public String getCust_linkman() {
		return cust_linkman;
	}

	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public String getCust_zipcode() {
		return cust_zipcode;
	}

	public void setCust_zipcode(String cust_zipcode) {
		this.cust_zipcode = cust_zipcode;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_createtime() {
		return cust_createtime;
	}

	public void setCust_createtime(String cust_createtime) {
		this.cust_createtime = cust_createtime;
	}

}
