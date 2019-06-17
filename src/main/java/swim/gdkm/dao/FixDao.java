package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Fix;

public interface FixDao {
	public List<Fix> getAllList();

	public Fix getFixByScanner(@Param("type") String type, @Param("code") String code);
}
