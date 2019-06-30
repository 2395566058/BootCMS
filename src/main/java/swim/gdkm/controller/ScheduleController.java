package swim.gdkm.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swim.gdkm.poji.Schedule;
import swim.gdkm.service.ScheduleService;

@Controller
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value = "/Schedule.action", method = RequestMethod.GET)
	public String getHtml() {
		return "Schedule.html";
	}
	
	/*
	 * 返回数据 获取整张schedule表数据
	 */
	@RequestMapping(value = "/getScheduleAll.action", method = RequestMethod.POST)
	@ResponseBody
	public String getScheduleAll() {
		List<Schedule> sc = scheduleService.getAllList();
		return getJson(sc).toString();
	}
	
	/*
	 * 返回数据 通过特定条件选择schedule表的行数据
	 */
	@RequestMapping(value = "/getScheduleByScreen.action", method = RequestMethod.POST)
	@ResponseBody
	public String getScheduleByScreen(String type,String code) {
		List<Schedule> sc = scheduleService.getScheduleByScanner(type, code);
		return getJson(sc).toString();
	}
	
	/*
	 * 返回数据 通过id选择schedule表的行数据
	 */
	@RequestMapping(value = "/getScheduleById.action", method = RequestMethod.POST)
	@ResponseBody
	public String getScheduleById(int sc_id) {
		Schedule sc = scheduleService.getScheduleById(sc_id);
		List<Schedule> list=null;
		list.add(sc);
		return getJson(list).toString();
	}
	
	/*
	 * 返回数据 添加一行schedule表数据
	 */
	@RequestMapping(value = "/addSchedule.action", method = RequestMethod.POST)
	@ResponseBody
	public boolean addSchedule(HttpServletRequest request) {
		Map<String,Object> map=getRequestMap(request);
		Schedule sc=new Schedule(map);
		boolean result=scheduleService.addScheduleList(sc);
		return result;
	}

	/*
	 * 返回数据 修改一行schedule表数据
	 */
	@RequestMapping(value = "/updateSchedule.action", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateSchedule(HttpServletRequest request) {
		Map<String,Object> map=getRequestMap(request);
		Schedule sc=new Schedule(map);
		boolean result=scheduleService.updateScheduleList(sc);
		return result;
	}

	/*
	 * 返回数据 删除一行schedule表数据
	 */
	@RequestMapping(value = "/deleteSchedule.action", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteSchedule(int sc_id) {
		boolean result=scheduleService.deleteScheduleList(sc_id);
		return result;
	}
	
	/*
	 * 将数据转成Json格式以待发送
	 */
	public static StringBuffer getJson(List<Schedule> list) {
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
			int sc_user_id = schedule.getSc_user_id();

			sb.append("{");
			sb.append("\"st_id\":\"" + sc_id + "\",");
			sb.append("\"sc_name\":\"" + sc_name + "\",");
			sb.append("\"sc_start\":\"" + sc_start + "\",");
			sb.append("\"sc_end\":\"" + sc_end + "\",");
			sb.append("\"sc_week\":\"" + sc_week + "\",");
			sb.append("\"sc_time\":\"" + sc_time + "\",");
			sb.append("\"sc_cl_id\":\"" + sc_cl_id + "\",");
			sb.append("\"sc_user_id\":\"" + sc_user_id + "\"");
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
	public static Map<String,Object> getRequestMap(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		Map<String, Object> newmap=new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, String[]> entry = it.next();
			newmap.put(entry.getKey(), JtoString(entry.getValue()));
		}
		return newmap;
	}
}
