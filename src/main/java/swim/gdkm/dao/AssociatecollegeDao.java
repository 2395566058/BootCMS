package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import swim.gdkm.poji.Associatecollege;
public interface AssociatecollegeDao {
	public List<Associatecollege> getAllList();

	public Associatecollege getAssociatecollegeByScanner(@Param("type") String type, @Param("code") String code);

}
