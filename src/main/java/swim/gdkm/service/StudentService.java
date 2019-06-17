package swim.gdkm.service;

import java.util.List;
import swim.gdkm.poji.Student;

public interface StudentService {

	public List<Student> getAllList();

	public Student getStudentByScanner(String type, String code);

}
