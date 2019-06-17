package swim.gdkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import swim.gdkm.dao.SysuserDao;
import swim.gdkm.poji.Sysuser;
import swim.gdkm.service.SysuserService;

public class SysuserServiceImpl implements SysuserService {
	@Autowired
	private SysuserDao sysuserDao;

	@Override
	public List<Sysuser> getAllList() {
		List<Sysuser> list=sysuserDao.getAllList();
		return list;
	}

	@Override
	public Sysuser getSysuserByScanner(String type,String code) {
		Sysuser sysuser=sysuserDao.getSysuserByScanner(type, code);
		return sysuser;
	}

}
