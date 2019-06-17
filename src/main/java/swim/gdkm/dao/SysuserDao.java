package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Sysuser;

public interface SysuserDao {
	public List<Sysuser> getAllList();

	public Sysuser getSysuserByScanner(@Param("type")String type,@Param("code")String code);
}
