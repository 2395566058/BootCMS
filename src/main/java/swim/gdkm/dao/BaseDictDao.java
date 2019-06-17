package swim.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Base_dict;

public interface BaseDictDao {
	public List<Base_dict> selectBaseDictByTypeCode(String typecode);
}
