package swim.gdkm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swim.gdkm.dao.SysuserDao;
import swim.gdkm.poji.Sysuser;
import swim.gdkm.service.SysuserService;

@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {
	@Autowired
	private SysuserDao sysuserDao;

	@Override
	public List<Sysuser> getAllList() {
		List<Sysuser> list = sysuserDao.getAllList();
		return list;
	}

	@Override
	public List<Sysuser> getSysuserByScanner(String type, String code) {
		List<Sysuser> sysuser = sysuserDao.getSysuserByScanner(type, code);
		return sysuser;
	}

	@Override
	public List<Sysuser> getSysuserByScannerMap(Map map, String updown, int updowntype) {
		List<Sysuser> sysuser=sysuserDao.getSysuserByScannerMap(map, updown, updowntype);
		return sysuser;
	}

}
