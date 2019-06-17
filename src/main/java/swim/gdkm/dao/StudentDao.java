package swim.gdkm.dao;

import java.util.List;
import swim.gdkm.poji.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
	public List<Student> getAllList();

	public Student getStudentByScanner(@Param("type")String type, @Param("code")String code);
}
