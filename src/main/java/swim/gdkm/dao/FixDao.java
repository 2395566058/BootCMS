package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Fix;
import swim.gdkm.poji.Major;

public interface FixDao {
	public List<Fix> getAllList();

	public List<Fix> getFixByScanner(@Param("type") String type, @Param("code") String code);
	
	public int addFix(Fix fix);

	public boolean deleteFix(int f_id);

	public int updateFix(Fix fix);
}
