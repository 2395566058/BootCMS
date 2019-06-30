package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Schedule;
import swim.gdkm.poji.Sysuser;

public interface ScheduleDao {
	public List<Schedule> getAllList();

	public List<Schedule> getScheduleByScanner(@Param("type") String type, @Param("code") String code);

	public Schedule getScheduleById(@Param("sc_id")int sc_id);

	public boolean addSchedule(Schedule schedule);

	public boolean deleteSchedule(int sc_id);

	public boolean updateSchedule(Schedule schedule);
}
