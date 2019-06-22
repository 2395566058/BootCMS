package swim.gdkm.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import swim.gdkm.poji.Sysuser;

public interface SysuserDao {
	public List<Sysuser> getAllList();

	public List<Sysuser> getSysuserByScanner(@Param("type") String type, @Param("code") String code);

	public List<Sysuser> getSysuserByScannerMap(@Param("map") Map map, @Param("updown") String updown,
			@Param("updowntype") int updowntype);

	public int addSysuser(Sysuser sysuser);

	public int deleteSysuser(int user_id);

	public int updateSysuser(Sysuser sysuser);
}
