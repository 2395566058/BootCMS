package swim.gdkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swim.gdkm.dao.ScheduleDao;
import swim.gdkm.poji.Schedule;
import swim.gdkm.service.ScheduleService;
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleDao scheduleDao;

	@Override
	public List<Schedule> getAllList() {
		List<Schedule> list = scheduleDao.getAllList();
		return list;
	}

	@Override
	public Schedule getScheduleByScanner(String type, String code) {
		Schedule schedule = scheduleDao.getScheduleByScanner(type, code);
		return schedule;
	}

}
