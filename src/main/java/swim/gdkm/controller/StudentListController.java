package swim.gdkm.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import swim.gdkm.poji.Associatecollege;
import swim.gdkm.poji.Fix;
import swim.gdkm.poji.Major;
import swim.gdkm.poji.Schedule;
import swim.gdkm.poji.Student;
import swim.gdkm.poji.Sysuser;
import swim.gdkm.service.AssociatecollegeService;
import swim.gdkm.service.FixService;
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
	@Autowired
	private AssociatecollegeService associatecollegeService;
	@Autowired
	private FixService fixService;

	@RequestMapping(value = "/StudentList.action", method = RequestMethod.GET)
	public String toLogin() {
		return "StudentList.html";
	}

	/*
	 * 返回数据 获取同院系的列表及自动排序
	 */
	@RequestMapping(value = "/StudentList.action", method = RequestMethod.POST)
	@ResponseBody
	public StringBuffer getInfo(@RequestParam("ask") String ask, @RequestParam("type") String type,
			HttpServletRequest request) {
		List<Student> list = null;
		Sysuser sy = (Sysuser) request.getSession().getAttribute("USER");
		int user_as_id = sy.getUser_as_id();
		list = studentService.getStudentByScannerUpDown("st_as_id", String.valueOf(user_as_id), ask,
				Integer.valueOf(type));
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
		map.put("st_name", request.getParameter("st_name"));
		map.put("st_user_id", user_id);
		map.put("st_as_id", user_as_id);
		Major major = majorService.getMajorByScanner("ma_name", request.getParameter("st_ma_id"));
		if (major!= null) {
			map.put("st_ma_id", major.getMa_id());
		} else {
			return "找不到专业:" + request.getParameter("st_ma_id");
		}
		map.put("st_admissiondate", request.getParameter("st_admissiondate"));
		map.put("st_phone", request.getParameter("st_phone"));
		map.put("st_address", request.getParameter("st_address"));
		map.put("st_registerdate", st_registerdate);
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
		if (schedule != null&& !schedule.equals("")) {
			String[] scheduleList = schedule.split("~");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < scheduleList.length; i++) {
				List<Schedule> sc = scheduleService.getScheduleByScanner("sc_name", scheduleList[i]);
				if (sc == null) {
					return "找不到课程:" + scheduleList[i];
				}
				sb.append(sc.get(0).getSc_id() + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			map.put("st_sc", sb.toString());
		}
		String sc_image = null;
		try {
			sc_image = storePic(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("st_image", sc_image);
		Student student = new Student(map);
		boolean result = studentService.addStudentList(student);
		if (result = true) {
			return "添加成功";
		}
		return "添加失败";
	}

	/*
	 * 返回数据 修改Student表数据 不包含st_image
	 */
	@RequestMapping(value = "/updateStudent.action", method = RequestMethod.POST)
	@ResponseBody
	public String updateStudentList(HttpServletRequest request) throws FileUploadException {
		Map<String, Object> newmap = new HashMap<String, Object>();
		String result = update(request, newmap);
		return result;
	}

	/*
	 * 返回数据 修改Student表数据 包含st_image
	 */
	@RequestMapping(value = "/updateStudentIncludeImage.action", method = RequestMethod.POST)
	@ResponseBody
	public String updateStudentListIncludeImage(@RequestParam("st_image") MultipartFile file,
			HttpServletRequest request) throws FileUploadException {
		Map<String, Object> newmap = new HashMap<String, Object>();
		String sc_image = null;
		try {
			sc_image = storePic(file);
		} catch (Exception e) {
			e.printStackTrace();
			return "图片上传失败,请重试！";
		}
		newmap.put("st_image", sc_image);
		String result = update(request, newmap);
		return result;
	}

	/*
	 * 返回数据 删除一行student数据
	 */
	@RequestMapping(value = "/deleteStudent.action", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteStudent(HttpServletRequest request) {
		Sysuser sy = (Sysuser) request.getSession().getAttribute("USER");
		String user_authorization = sy.getUser_authorization();
		if (!user_authorization.equals("2")) {
			// 没有权限删除
			return false;
		}
		String id = request.getParameter("st_id");
		int st_id = Integer.valueOf(id);
		List<Fix> fix = fixService.getFixByScanner("f_st_id", id);
		if (fix.size() != 0 || fix != null) {
			for (int i = 0; i < fix.size(); i++) {
				boolean result2 = fixService.deleteFix(fix.get(i).getF_id());
				if (result2 != true) {
					return result2;
				}
			}
		}
		boolean result = studentService.deleteStudent(st_id);
		return result;
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
			if (list.get(i).getSt_sex().equals("1") || list.get(i).getSt_sex().equals("男")) {
				sb.append("\"st_sex\":\"男\",");
			} else {
				sb.append("\"st_sex\":\"女\",");
			}
			Major major = majorService.getMajorByScanner("ma_id", String.valueOf(list.get(i).getSt_ma_id()));
			sb.append("\"st_ma_id\":\"" + major.getMa_name() + "\",");
			sb.append("\"st_phone\":\"" + list.get(i).getSt_phone() + "\",");
			List<Sysuser> sysuser = sysuserService.getSysuserByScanner("user_id",
					String.valueOf(list.get(i).getSt_user_id()));
			sb.append("\"st_user_id\":\"" + sysuser.get(0).getUser_name() + "\",");
			sb.append("\"st_image\":\"" + list.get(i).getSt_image() + "\",");
			Associatecollege associatecollege = associatecollegeService.getAssociatecollegeByScanner("as_id",
					String.valueOf(list.get(0).getSt_as_id()));
			sb.append("\"st_as_id\":\"" + associatecollege.getAs_name() + "\",");
			sb.append("\"st_registerdate\":\"" + list.get(i).getSt_registerdate() + "\",");
			sb.append("\"st_address\":\"" + list.get(i).getSt_address() + "\"");
			String a=list.get(i).getSt_sc();
			if (a!=null&&!a.equals("")) {
				String data_st_sc = list.get(i).getSt_sc();
				String[] list_st_sc = data_st_sc.split(",");
				String st_sc = "";
				for (int x = 0; x < list_st_sc.length; x++) {
					st_sc = st_sc + scheduleService.getScheduleById(Integer.valueOf(list_st_sc[x])).getSc_name() + "~";
				}
				st_sc = st_sc.substring(0, st_sc.length() - 1);
				sb.append(",\"st_sc\":\"" + st_sc + "\"");
			}
			sb.append("},");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb;
	}

	/*
	 * 把String数组转为String
	 */
	public String JtoString(String[] data) {
		if (data.length == 0 || data == null) {
			return null;
		}
		String newdata = "";
		for (int i = 0; i < data.length; i++) {
			newdata = newdata + data[i];
		}
		return newdata.toString();
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

	/*
	 * 遍历request内容并存到newmap进行student实例化
	 */
	@SuppressWarnings("unused")
	public String update(HttpServletRequest request, Map<String, Object> newmap) {
		Sysuser sy = (Sysuser) request.getSession().getAttribute("USER");
		String user_authorization = sy.getUser_authorization();
		if (!user_authorization.equals("2")) {
			return "没有权限更改！";
		}
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		Iterator<Entry<String, String[]>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, String[]> entry = it.next();
			newmap.put(entry.getKey(), JtoString(entry.getValue()));
		}
		if (newmap.get("st_admissiondate") != null) {
			String isValidstr = (String) newmap.get("st_admissiondate");
			boolean isValid = isValidDate(isValidstr);
			if (isValid == false) {
				return "时间格式非法！";
			}
		}
		if (newmap.get("st_born") != null) {
			String isValidstr = (String) newmap.get("st_born");
			boolean isValid = isValidDate(isValidstr);
			if (isValid == false) {
				return "时间格式非法！";
			}
		}
		String st_user_id = (String) newmap.get("st_user_id");
		String st_as_id = (String) newmap.get("st_as_id");
		Associatecollege associatecollege = new Associatecollege();
		if (st_as_id == null) {
			associatecollege.setAs_id(sy.getUser_as_id());
		}else {
			associatecollege=associatecollegeService.getAssociatecollegeByScanner("as_id", st_as_id);
		}
		if (associatecollege != null) {
			newmap.put("st_as_id", associatecollege.getAs_id());
			// 该院系存在
			Map<String, Object> map1 = new HashMap<String, Object>();
			if (st_user_id != null) {
				map1.put("user_name", st_user_id);
				map1.put("user_as_id", associatecollege.getAs_id());
				List<Sysuser> sysuser = sysuserService.getSysuserByScannerMap(map1, "user_id", 0);
				// 该管理员存在
				if (sysuser.size() != 0) {
					newmap.put("st_user_id", sysuser.get(0).getUser_id());
					newmap.put("st_as_id", associatecollege.getAs_id());
				} else {
					return "该管理人不存在！";
				}
			}
			String st_ma_id = (String) newmap.get("st_ma_id");
			Major major = new Major();
			if (st_ma_id != null) {
				major = majorService.getMajorByScanner("ma_name", st_ma_id);
				if(major==null) {
					return "找不到该专业！";
				}
				if (associatecollege != null) {
					if (major.getMa_as_id() != associatecollege.getAs_id()) {
						System.out.println("major.getMa_as_id()="+major.getMa_as_id());
						System.out.println(" associatecollege.getAs_id()="+ associatecollege.getAs_id());
						return "专业与院系不符！";
					} else {
						newmap.put("st_ma_id", major.getMa_id());
					}
				} else {
					String st_id = (String) newmap.get("st_id");
					List<Student> student = studentService.getStudentByScanner("st_id", st_id);
					if (major.getMa_as_id() != student.get(0).getSt_as_id()) {
						return "专业与院系不符！";
					} else {
						newmap.put("st_ma_id", major.getMa_id());
					}
				}
			}
		} else {
			return "该院系不存在！";
		}
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String st_registerdate = f.format(new Date());
		newmap.put("st_registerdate", st_registerdate);
		String sex = (String) newmap.get("st_sex");
		if (sex != null) {
			if (sex.equals("男") || sex.equals("1")) {
				newmap.put("st_sex", "1");
			} else if (sex.equals("女") || sex.equals("0")) {
				newmap.put("st_sex", "0");
			} else {
				return "性别错误:" + sex;
			}
		}
		String schedule = (String) newmap.get("st_sc");
		if (schedule != null) {
			String[] scheduleList = schedule.split("~");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < scheduleList.length; i++) {
				List<Schedule> sc = scheduleService.getScheduleByScanner("sc_name", scheduleList[i]);
				if (sc.size()==0) {
					return "找不到课程:" + scheduleList[i];
				}
				sb.append(sc.get(0).getSc_id() + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			newmap.put("st_sc", sb.toString());
		}
		Student student = new Student(newmap);
		boolean result = studentService.updateStudent(student);
		if (result = true) {
			return "更改成功";
		}
		return "更改失败";
	}

	/*
	 * 判断字符串是否为时间格式
	 */
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			format.setLenient(false);
			format.parse(str);
		} catch (java.text.ParseException e) {
			convertSuccess = false;
			return convertSuccess;
		}
		return convertSuccess;
	}
}
