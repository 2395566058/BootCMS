package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Classes;

public interface ClassesDao {
	public List<Classes> getAllList();

	public Classes getClassesByScanner(@Param("type") String type, @Param("code") String code);
}
