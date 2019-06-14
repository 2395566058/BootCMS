package swim.gdkm.poji;

import java.io.Serializable;

/*
 *	数据字典表
 */

public class Base_dict implements Serializable {
	private static final long serialVersionUID = 1L;
	private String dict_id;// 数据字典id
	private String dict_type_code;// 数据字典类别代码
	private String dict_type_name;// 数据字典类别名称
	private String dict_item_name;// 数据字典项目名称
	private String dict_item_code;// 数据字典项目代码
	private int dict_sort;// 排序字段
	private char dict_enable;// 是否可用:1:使用0:停用
	private String dict_memo;// 备注

	public String getDict_id() {
		return dict_id;
	}

	public void setDict_id(String dict_id) {
		this.dict_id = dict_id;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public String getDict_type_name() {
		return dict_type_name;
	}

	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}

	public String getDict_item_name() {
		return dict_item_name;
	}

	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}

	public String getDict_item_code() {
		return dict_item_code;
	}

	public void setDict_item_code(String dict_item_code) {
		this.dict_item_code = dict_item_code;
	}

	public int getDict_sort() {
		return dict_sort;
	}

	public void setDict_sort(int dict_sort) {
		this.dict_sort = dict_sort;
	}

	public char getDict_enable() {
		return dict_enable;
	}

	public void setDict_enable(char dict_enable) {
		this.dict_enable = dict_enable;
	}

	public String getDict_memo() {
		return dict_memo;
	}

	public void setDict_memo(String dict_memo) {
		this.dict_memo = dict_memo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
