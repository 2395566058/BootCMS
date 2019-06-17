package swim.gdkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swim.gdkm.dao.ClassesDao;
import swim.gdkm.poji.Classes;
import swim.gdkm.service.ClassesService;
@Service("classesService")
public class ClassesServiceImpl implements ClassesService {
	@Autowired
	private ClassesDao classesDao;

	@Override
	public List<Classes> getAllList() {
		List<Classes> list = classesDao.getAllList();
		return list;
	}

	@Override
	public Classes getClassesByScanner(String type, String code) {
		Classes classes = classesDao.getClassesByScanner(type, code);
		return classes;
	}
}
