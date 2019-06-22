package swim.gdkm.service;

import java.util.List;
import java.util.Map;
import swim.gdkm.poji.Sysuser;

public interface SysuserService {
	public List<Sysuser> getAllList();

	public List<Sysuser> getSysuserByScanner(String type, String code);

	public List<Sysuser> getSysuserByScannerMap(Map map, String updown, int updowntype);
}
