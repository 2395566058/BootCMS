package swim.gdkm.controller;

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

	@RequestMapping(value = "/existSchedule.action", method = RequestMethod.POST)
	@ResponseBody
	public boolean existSchedule(String sc_name) {
		Schedule schedule = scheduleService.getScheduleByScanner("sc_name", sc_name);
		if (schedule != null) {
			return true;
		}
		return false;
	}
}
