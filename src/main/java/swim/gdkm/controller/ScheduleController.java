package swim.gdkm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swim.gdkm.poji.Classes;
import swim.gdkm.poji.Schedule;
import swim.gdkm.poji.Sysuser;
import swim.gdkm.service.ClassesService;
import swim.gdkm.service.ScheduleService;
import swim.gdkm.service.StudentService;
import swim.gdkm.service.SysuserService;

@Controller
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private ClassesService classesService;
	@Autowired
	private SysuserService sysuserService;
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/Curriculum.action", method = RequestMethod.GET)
	public String getHtml() {
		return "Curriculum.html";
	}

	/*
	 * 返回数据 获取整张schedule表数据
	 */
	@RequestMapping(value = "/getScheduleAll.action", method = RequestMethod.POST)
	@ResponseBody
	public String getScheduleAll() {
		List<Schedule> sc = scheduleService.getAllList();
		return getJson(sc,classesService,sysuserService).toString();
	}

	/*
	 * 返回数据 通过特定条件选择schedule表的行数据
	 */
	@RequestMapping(value = "/getScheduleByScreen.action", method = RequestMethod.POST)
	@ResponseBody
	public String getScheduleByScreen(String type, String code) {
		List<Schedule> sc = scheduleService.getScheduleByScanner(type, code);
		return getJson(sc,classesService,sysuserService).toString();
	}

	/*
	 * 返回数据 通过id选择schedule表的行数据
	 */
	@RequestMapping(value = "/getScheduleById.action", method = RequestMethod.POST)
	@ResponseBody
	public String getScheduleById(int sc_id) {
		Schedule sc = scheduleService.getScheduleById(sc_id);
		List<Schedule> list = null;
		list.add(sc);
		return getJson(list,classesService,sysuserService).toString();
	}

	/*
	 * 返回数据 添加一行schedule表数据
	 */
	@RequestMapping(value = "/addSchedule.action", method = RequestMethod.POST)
	@ResponseBody
	public String addSchedule(HttpServletRequest request) {
		Sysuser sy = (Sysuser) request.getSession().getAttribute("USER");
		String user_authorization = sy.getUser_authorization();
		int user_id = sy.getUser_id();
		int user_as_id = sy.getUser_as_id();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String st_registerdate = f.format(new Date());
		if (!user_authorization.equals("2")) {
			return "没有权限添加！";
		}
		Map<String, Object> map = getRequestMap(request);
		String sc_name=(String) map.get("sc_name");
		if(scheduleService.getScheduleByScanner("sc_name",sc_name).size()!=0) {
			return "已有相同名字课程！";
		}
		String sc_start=(String) map.get("sc_start");
		String sc_end=(String) map.get("sc_end");
		if(isValidDate(sc_start)==false) {
			return "开始时间格式非法！";
		}
		if(isValidDate(sc_end)==false) {
			return "开始时间格式非法！";
		}
		String sc_user_id=(String) map.get("sc_user_id");
		List<Sysuser> sysuser=sysuserService.getSysuserByScanner("user_code",sc_user_id);
		if(sysuser!=null) {
			sc_user_id=String.valueOf(sysuser.get(0).getUser_id());
			map.put("sc_user_id", sc_user_id);
		}else {
			return "没有该老师";
		}
		String sc_cl_id=(String) map.get("sc_cl_id");
		Classes classes=classesService.getClassesByScanner("cl_name", sc_cl_id);
		if(classes!=null) {
			sc_cl_id=String.valueOf(classes.getCl_id());
			System.out.println("sc_cl_id="+sc_cl_id);
			map.put("sc_cl_id", sc_cl_id);
		}else {
			return "找不到该课室";
		}
		Schedule sc = new Schedule(map);
		boolean result = scheduleService.addScheduleList(sc);
		if(result==true) {
			return "添加成功";
		}
		return "添加失败";
	}

	/*
	 * 返回数据 修改一行schedule表数据
	 */
	@RequestMapping(value = "/updateSchedule.action", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateSchedule(HttpServletRequest request) {
		Map<String, Object> map = getRequestMap(request);
		Schedule sc = new Schedule(map);
		boolean result = scheduleService.updateScheduleList(sc);
		return result;
	}
	
	/*
	 * 获取要删除的课程有几个人在学习
	 */
	@RequestMapping(value = "/booleanDeleteSchedule.action", method = RequestMethod.POST)
	@ResponseBody
	public int booleanDeleteSchedule(int sc_id) {
		int result=studentService.likescheduleBySc_id("%"+sc_id+"%");
		return result;
	}

	/*
	 * 返回数据 删除一行schedule表数据
	 */
	@RequestMapping(value = "/deleteSchedule.action", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteSchedule(int sc_id) {
		boolean result = scheduleService.deleteScheduleList(sc_id);
		if(result==true) {
			String aa=sc_id+",";
			studentService.updatelikeBysc_id(aa);
			studentService.updatelikeBysc_id(String.valueOf(sc_id));
		}
		return result;
	}

	/*
	 * 将数据转成Json格式以待发送
	 */
	public static StringBuffer getJson(List<Schedule> list,ClassesService classesService,SysuserService sysuserService) {
		StringBuffer sb = new StringBuffer("[");
		if (list.size() == 0) {
			return new StringBuffer("null");
		}
		for (int i = 0; i < list.size(); i++) {
			Schedule schedule = list.get(i);
			int sc_id = schedule.getSc_id();
			String sc_name = schedule.getSc_name();
			String sc_start = schedule.getSc_start();
			String sc_end = schedule.getSc_end();
			String sc_week = schedule.getSc_week();
			String sc_time = schedule.getSc_time();
			int sc_cl_id = schedule.getSc_cl_id();
			String sc_cl=classesService.getClassesByScanner("cl_id", String.valueOf(sc_cl_id)).getCl_name();
			int sc_user_id = schedule.getSc_user_id();
			String user_name=sysuserService.getSysuserByScanner("user_id",String.valueOf(sc_user_id)).get(0).getUser_name();
			sb.append("{");
			sb.append("\"sc_id\":\"" + sc_id + "\",");
			sb.append("\"sc_name\":\"" + sc_name + "\",");
			sb.append("\"sc_start\":\"" + sc_start + "\",");
			sb.append("\"sc_end\":\"" + sc_end + "\",");
			sb.append("\"sc_week\":\"" + sc_week + "\",");
			sb.append("\"sc_time\":\"" + sc_time + "\",");
			sb.append("\"sc_cl_id\":\"" + sc_cl + "\",");
			sb.append("\"sc_user_id\":\"" + user_name + "\"");
			sb.append("},");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb;
	}

	/*
	 * 把String数组转为String
	 */
	public static String JtoString(String[] data) {
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
	 * 遍历request内容并存到map
	 */
	public static Map<String, Object> getRequestMap(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		Map<String, Object> newmap = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, String[]> entry = it.next();
			newmap.put(entry.getKey(), JtoString(entry.getValue()));
		}
		return newmap;
	}
	/*
	 * 判断是否为时间格式
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
