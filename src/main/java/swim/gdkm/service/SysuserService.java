package swim.gdkm.service;

import java.util.List;
import swim.gdkm.poji.Sysuser;

public interface SysuserService {
	public List<Sysuser> getAllList();

	public List<Sysuser> getSysuserByScanner(String type, String code);
}
