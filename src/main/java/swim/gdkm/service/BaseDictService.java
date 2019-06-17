package swim.gdkm.service;

import java.util.List;

import swim.gdkm.poji.Base_dict;

public interface BaseDictService {
	public List<Base_dict> findBaseDictByTypeCode(String typecode);
}
