package swim.gdkm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swim.gdkm.dao.StudentDao;
import swim.gdkm.poji.Student;
import swim.gdkm.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getAllList() {
		List<Student> list = studentDao.getAllList();
		return list;
	}

	@Override
	public List<Student> getStudentByScanner(String type, String code) {
		List<Student> student = studentDao.getStudentByScanner(type, code);
		return student;
	}

	@Override
	public List<Student> getStudentByScannerUpDown(String type, String code, String updown, int updowntype) {
		List<Student> student = studentDao.getStudentByScannerUpDown(type, code, updown, updowntype);
		return student;
	}

	@Override
	public List<Student> getStudentByScanner(Map map, String updown, int updowntype) {
		List<Student> student = studentDao.getStudentByScanner(map, updown, updowntype);
		return student;
	}
}
