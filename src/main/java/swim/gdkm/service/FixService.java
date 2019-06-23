package swim.gdkm.service;

import java.util.List;

import swim.gdkm.poji.Fix;

public interface FixService {
	public List<Fix> getAllList();

	public List<Fix> getFixByScanner(String type, String code);
	
	public boolean deleteFix(int f_id);
}
