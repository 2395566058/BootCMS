package swim.gdkm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import swim.gdkm.dao.StudentDao;
import swim.gdkm.poji.Student;
import swim.gdkm.service.StudentService;

public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getAllList() {
		List<Student> list = studentDao.getAllList();
		return list;
	}

	@Override
	public Student getStudentByScanner(String type, String code) {
		Student student = studentDao.getStudentByScanner(type, code);
		return student;
	}
}
