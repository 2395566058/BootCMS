package swim.gdkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swim.gdkm.dao.ScheduleDao;
import swim.gdkm.dao.StudentDao;
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
	public List<Schedule> getScheduleByScanner(String type, String code) {
		List<Schedule> schedule = scheduleDao.getScheduleByScanner(type, code);
		return schedule;
	}

	@Override
	public Schedule getScheduleById(int sc_id) {
		Schedule schedule = scheduleDao.getScheduleById(sc_id);
		return schedule;
	}

	@Override
	public boolean addScheduleList(Schedule schedule) {
		boolean result = scheduleDao.addSchedule(schedule);
		return result;
	}

	@Override
	public boolean updateScheduleList(Schedule schedule) {
		boolean result = scheduleDao.updateSchedule(schedule);
		return result;
	}

	@Override
	public boolean deleteScheduleList(int sc_id) {
		boolean result = scheduleDao.deleteSchedule(sc_id);
		return result;
	}

}
