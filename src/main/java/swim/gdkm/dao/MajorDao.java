package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Major;

public interface MajorDao {
	public List<Major> getAllList();

	public Major getMajorByScanner(@Param("type")String type, @Param("code")String code);
}
