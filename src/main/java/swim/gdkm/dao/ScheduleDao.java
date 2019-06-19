package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Schedule;
import swim.gdkm.poji.Sysuser;

public interface ScheduleDao {
	public List<Schedule> getAllList();

	public Schedule getScheduleByScanner(@Param("type") String type, @Param("code") String code);
	
	public int addSchedule(Schedule schedule);

	public int deleteSchedule(int sc_id);

	public int updateSchedule(Schedule schedule);
}
