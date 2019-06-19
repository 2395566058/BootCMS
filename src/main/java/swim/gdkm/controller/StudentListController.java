package swim.gdkm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swim.gdkm.poji.Major;
import swim.gdkm.poji.Student;
import swim.gdkm.poji.Sysuser;
import swim.gdkm.service.MajorService;
import swim.gdkm.service.StudentService;
/*
 * 学生列表页面
 */

@Controller
public class StudentListController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private MajorService majorService;

	@RequestMapping(value = "/StudentList.action", method = RequestMethod.GET)
	public String toLogin() {
		return "StudentList.html";
	}

	/*
	 * 返回数据 获取同院系的列表及自动排序
	 */
	@RequestMapping(value = "/StudentList.action", method = RequestMethod.POST)
	@ResponseBody
	public StringBuffer getInfo(String ask, int type, HttpServletRequest request) {
		List<Student> list = null;
		Sysuser sy = (Sysuser) request.getSession().getAttribute("USER");
		int user_as_id = sy.getUser_as_id();
		list = studentService.getStudentByScannerUpDown("st_ as_id", String.valueOf(user_as_id), ask, type);
		StringBuffer sb = getJson(list);
		return sb;
	}

	/*
	 * 返回数据 返回经过筛选的StudentList表
	 */
	@RequestMapping(value = "/StudentListScreen.action", method = RequestMethod.POST)
	@ResponseBody
	public StringBuffer getInfoByScreen(String column, String ask, int type, HttpServletRequest request) {
		String[] newcolumn = column.split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; 0 < newcolumn.length; i++) {
			map.put(newcolumn[i], request.getParameter(newcolumn[i]));
		}
		List<Student> student = studentService.getStudentByScanner(map, ask, type);
		StringBuffer sb = getJson(student);
		return sb;
	}

	public StringBuffer getJson(List<Student> list) {
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < list.size(); i++) {
			sb.append("{");
			sb.append("\"st_id\":\"" + list.get(i).getSt_id() + "\",");
			sb.append("\"st_name\":\"" + list.get(i).getSt_name() + "\",");
			Major major = majorService.getMajorByScanner("as_id", String.valueOf(list.get(i).getSt_ma_id()));
			sb.append("\"st_ma_id\":\"" + major.getMa_name() + "\",");
			sb.append("\"st_admissiondate\":\"" + list.get(i).getSt_admissiondate() + "\",");
			sb.append("\"st_phone\":\"" + list.get(i).getSt_phone() + "\",");
			sb.append("\"st_address\":\"" + list.get(i).getSt_address() + "\",");
			sb.append("\"st_registerdate\":\"" + list.get(i).getSt_registerdate() + "\",");
			sb.append("\"st_born\":\"" + list.get(i).getSt_born() + "\",");
			if (list.get(i).getSt_sex() == 1) {
				sb.append("\"st_sex\":\"男\",");
			}
			sb.append("\"st_sex\":\"女\",");
			sb.append("\"st_image\":\"" + list.get(i).getSt_image() + "\"");
			sb.append("},");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb;
	}
}
