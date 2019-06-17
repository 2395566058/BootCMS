package swim.gdkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swim.gdkm.dao.MajorDao;
import swim.gdkm.poji.Major;
import swim.gdkm.service.MajorService;
@Service("majorService")
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorDao majorDao;

	@Override
	public List<Major> getAllList() {
		List<Major> list = majorDao.getAllList();
		return list;
	}

	@Override
	public Major getMajorByScanner(String type, String code) {
		Major major = majorDao.getMajorByScanner(type, code);
		return major;
	}
}
