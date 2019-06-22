package swim.gdkm.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import swim.gdkm.poji.Major;
import swim.gdkm.poji.Schedule;
import swim.gdkm.poji.Student;
import swim.gdkm.poji.Sysuser;
import swim.gdkm.service.MajorService;
import swim.gdkm.service.ScheduleService;
import swim.gdkm.service.StudentService;
import swim.gdkm.service.SysuserService;
/*
 * 学生列表页面
 */

@Controller
public class StudentListController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private SysuserService sysuserService;
	@Autowired
	private ScheduleService scheduleService;

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
		list = studentService.getStudentByScannerUpDown("st_as_id", String.valueOf(user_as_id), ask, type);
		return getJson(list);
	}

	/*
	 * 返回数据 返回经过筛选的Student表
	 */
	@RequestMapping(value = "/StudentListScreen.action", method = RequestMethod.POST)
	@ResponseBody
	public StringBuffer getInfoByScreen(String json, String ask, int type) {
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> map = jsonParser.parseMap(json);
		if (map.get("st_id") != null) {
			map.remove("st_id");
		}
		if (map.get("st_sex") != null) {
			String sex = (String) map.get("st_sex");
			if (sex.indexOf("男") >= 0) {
				map.put("st_sex", "1");
			}
			if (sex.indexOf("女") >= 0) {
				map.put("st_sex", "0");
			}
		}
		if (map.get("st_ma_id") != null) {
			String ma_name = (String) map.get("st_ma_id");
			Major major = majorService.getMajorByScanner("ma_name", ma_name);
			int ma_id = major.getMa_id();
			map.put("st_ma_id", ma_id);
		}
		if (map.get("st_user_id") != null) {
			String user_name = (String) map.get("st_user_id");
			List<Sysuser> sysuser = sysuserService.getSysuserByScanner("user_name", user_name);
			if (sysuser.size() > 1) {
				StringBuffer st_user_id = new StringBuffer();
				for (int i = 0; i < sysuser.size(); i++) {// 1" OR user_id = "2
					st_user_id.append(sysuser.get(i).getUser_id() + "\" OR st_user_id =\"");
				}
				String result = st_user_id.substring(0, st_user_id.lastIndexOf("OR") - 2);
				map.put("st_user_id", result);
			} else {
				int st_user_id = sysuser.get(0).getUser_id();
				map.put("st_user_id", st_user_id);
			}
		}

		List<Student> student = studentService.getStudentByScannerMap(map, ask, type);
		return getJson(student);
	}

	// 将list转化为Json字符串
	public StringBuffer getJson(List<Student> list) {
		StringBuffer sb = new StringBuffer("[");
		if (list.size() == 0) {
			return new StringBuffer("null");
		}
		for (int i = 0; i < list.size(); i++) {
			sb.append("{");
			sb.append("\"st_id\":\"" + list.get(i).getSt_id() + "\",");
			sb.append("\"st_name\":\"" + list.get(i).getSt_name() + "\",");
			sb.append("\"st_admissiondate\":\"" + list.get(i).getSt_admissiondate() + "\",");
			sb.append("\"st_born\":\"" + list.get(i).getSt_born() + "\",");
			if (list.get(i).getSt_sex() == 1) {
				sb.append("\"st_sex\":\"男\",");
			}
			sb.append("\"st_sex\":\"女\",");
			Major major = majorService.getMajorByScanner("ma_id", String.valueOf(list.get(i).getSt_ma_id()));
			sb.append("\"st_ma_id\":\"" + major.getMa_name());
			sb.append("\"st_phone\":\"" + list.get(i).getSt_phone() + "\",");
			List<Sysuser> sysuser = sysuserService.getSysuserByScanner("user_id",
					String.valueOf(list.get(i).getSt_user_id()));
			sb.append("\"st_user_id\":\"" + sysuser.get(0).getUser_name() + "\"");
			sb.append("},");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb;
	}

	/*
	 * 返回数据 添加一行Student表数据
	 */
	@RequestMapping(value = "/AddStudentList.action", method = RequestMethod.POST)
	@ResponseBody
	public String addStudentList(@RequestParam("st_image") MultipartFile file, HttpServletRequest request) {
		Sysuser sy = (Sysuser) request.getSession().getAttribute("USER");
		String user_authorization = sy.getUser_authorization();
		int user_id = sy.getUser_id();
		int user_as_id = sy.getUser_as_id();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String st_registerdate = f.format(new Date());
		if (!user_authorization.equals("2")) {
			return "没有权限添加！";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		// 添加请求内容
		map.put("st_name", request.getParameter("st_name"));
		map.put("st_user_id", user_id);
		map.put("st_as_id", user_as_id);
		map.put("st_registerdate", st_registerdate);
		Major major = majorService.getMajorByScanner("ma_name", request.getParameter("st_ma_id"));
		if (String.valueOf(major.getMa_id()) != null || !String.valueOf(major.getMa_id()).equals("")) {
			map.put("st_ma_id", major.getMa_id());
		} else {
			return "找不到专业:" + map.get("st_ma_id");
		}
		map.put("st_admissiondate", request.getParameter("st_admissiondate"));
		map.put("st_phone", request.getParameter("st_phone"));
		map.put("st_address", request.getParameter("st_address"));
		map.put("st_registerdate", request.getParameter("st_registerdate"));
		map.put("st_born", request.getParameter("st_born"));
		String sex = request.getParameter("st_sex");
		if (sex.equals("男") || sex.equals("1")) {
			map.put("st_sex", "1");
		} else if (sex.equals("女") || sex.equals("1")) {
			map.put("st_sex", "0");
		} else {
			return "性别错误:" + sex;
		}
		String schedule = request.getParameter("st_sc");
		if (schedule != null || !schedule.equals("")) {
			String[] scheduleList = schedule.split("~");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < scheduleList.length; i++) {
				Schedule sc = scheduleService.getScheduleByScanner("sc_name", scheduleList[i]);
				if (sc.getSc_id() == 0) {
					return "找不到课程:" + scheduleList[i];
				}
				sb.append(sc.getSc_id() + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			map.put("st_sc", sb);
		}
		String sc_image = null;
		try {
			sc_image = storePic(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("st_image=" + sc_image);
		map.put("st_image", sc_image);
		Student student = new Student(map);
		boolean result = studentService.addStudentList(student);
		if (result = true) {
			return "添加成功";
		}
		return "添加失败";
	}

	/*
	 * 返回数据 修改Student表数据
	 */
	@RequestMapping(value = "/updateStudentList.action", method = RequestMethod.POST)
	@ResponseBody
	public String updateStudentList(String json, HttpServletRequest request) {
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> map = jsonParser.parseMap(json);

		return null;
	}

	/*
	 * 存入图片数据并返回地址
	 */
	private String storePic(MultipartFile data) throws Exception {
		String exName = data.getOriginalFilename().substring(data.getOriginalFilename().lastIndexOf("."));
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + exName;
		String uploadPicPath = "file:/root/BootCMSData/images/" + fileName;
		File file = new File(new URI(uploadPicPath));
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			data.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "http://120.79.218.123:8848/BootCMS/images/" + fileName;
	}

}
