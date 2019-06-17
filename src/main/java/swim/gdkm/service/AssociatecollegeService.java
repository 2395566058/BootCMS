package swim.gdkm.service;

import java.util.List;

import swim.gdkm.poji.Associatecollege;

public interface AssociatecollegeService {

	public List<Associatecollege> getAllList();

	public Associatecollege getAssociatecollegeByScanner(String type, String code);
}
