package swim.gdkm.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
	public List<Student> getStudentByScanner(@Param("type") String type, @Param("code") String code) {
		List<Student> student = studentDao.getStudentByScanner(type, code);
		return student;
	}

	@Override
	public List<Student> getStudentByScannerUpDown(@Param("type") String type, @Param("code") String code,
			@Param("updown") String updown, @Param("updowntype") int updowntype) {
		System.out.println("type=" + type + ",code=" + code + ",updown=" + updown + ",updowntype=" + updowntype);
		List<Student> student = studentDao.getStudentByScannerUpDown(type, code, updown, updowntype);
		return student;
	}

	@Override
	public List<Student> getStudentByScannerMap(@Param("map")Map map, @Param("updown")String updown, @Param("updowntype")int updowntype) {
		List<Student> student = studentDao.getStudentByScannerMap(map, updown, updowntype);
		return student;
	}

	@Override
	public boolean addStudentList(Student student) {
		boolean result = studentDao.addStudent(student);
		return result;
	}

}
