package swim.gdkm.service;

import java.util.List;
import java.util.Map;
import swim.gdkm.poji.Student;

public interface StudentService {

	public List<Student> getAllList();

	public List<Student> getStudentByScanner(String type, String code);

	public List<Student> getStudentByScannerUpDown(String type, String code, String updown, int updowntype);

	public List<Student> getStudentByScannerMap(Map map, String updown, int updowntype);

	public boolean addStudentList(Student student);

	public boolean updateStudent(Student student);
}
