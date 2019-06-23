package swim.gdkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swim.gdkm.dao.FixDao;
import swim.gdkm.poji.Fix;
import swim.gdkm.service.FixService;

@Service("fixService")
public class FixServiceImpl implements FixService {
	@Autowired
	private FixDao fixDao;

	@Override
	public List<Fix> getAllList() {
		List<Fix> list = fixDao.getAllList();
		return list;
	}

	@Override
	public List<Fix> getFixByScanner(String type, String code) {
		List<Fix> fix = fixDao.getFixByScanner(type, code);
		return fix;
	}

	@Override
	public boolean deleteFix(int f_id) {
		boolean result = fixDao.deleteFix(f_id);
		return result;
	}

}
