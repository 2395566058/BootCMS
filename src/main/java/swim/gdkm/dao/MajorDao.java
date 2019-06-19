package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Major;
import swim.gdkm.poji.Schedule;

public interface MajorDao {
	public List<Major> getAllList();

	public Major getMajorByScanner(@Param("type")String type, @Param("code")String code);
	
	public int addMajor(Major major);

	public int deleteMajor(int ma_id);

	public int updateMajor(Major major);
}
