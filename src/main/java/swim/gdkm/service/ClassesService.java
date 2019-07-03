package swim.gdkm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import swim.gdkm.poji.Classes;

public interface ClassesService {
	public List<Classes> getAllList();

	public Classes getClassesByScanner(String type, String code);
}
