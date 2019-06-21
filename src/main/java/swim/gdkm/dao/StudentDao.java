package swim.gdkm.dao;

import java.util.List;
import java.util.Map;

import swim.gdkm.poji.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
	public List<Student> getAllList();
	

	public List<Student> getStudentByScanner(@Param("type") String type, @Param("code") String code);

	public List<Student> getStudentByScannerUpDown(@Param("type") String type, @Param("code") String code,
			@Param("updown") String updown, @Param("updowntype") int updowntype);

	public List<Student> getStudentByScannerMap(@Param("map") Map map, @Param("updown") String updown,
			@Param("updowntype") int updowntype);

	public boolean addStudent(Student student);

	public boolean deleteStudent(int st_id);
	
	public boolean updateStudent(Student student);
}
