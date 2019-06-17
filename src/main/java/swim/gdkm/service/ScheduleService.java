package swim.gdkm.service;

import java.util.List;

import swim.gdkm.poji.Schedule;

public interface ScheduleService {
	public List<Schedule> getAllList();

	public Schedule getScheduleByScanner(String type, String code);
}
