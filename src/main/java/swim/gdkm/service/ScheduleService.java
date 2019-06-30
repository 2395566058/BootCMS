package swim.gdkm.service;

import java.util.List;

import swim.gdkm.poji.Schedule;

public interface ScheduleService {
	public List<Schedule> getAllList();

	public List<Schedule> getScheduleByScanner(String type, String code);
	
	public Schedule getScheduleById(int sc_id);
	
	public boolean addScheduleList(Schedule schedule);
	
	public boolean updateScheduleList(Schedule schedule);
	
	public boolean deleteScheduleList(int sc_id);
}
