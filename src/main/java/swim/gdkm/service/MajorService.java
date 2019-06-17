package swim.gdkm.service;

import java.util.List;

import swim.gdkm.poji.Major;

public interface MajorService {
	public List<Major> getAllList();

	public Major getMajorByScanner(String type, String code);
}
