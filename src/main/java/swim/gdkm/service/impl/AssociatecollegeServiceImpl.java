package swim.gdkm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swim.gdkm.dao.AssociatecollegeDao;
import swim.gdkm.poji.Associatecollege;
import swim.gdkm.service.AssociatecollegeService;

@Service("associatecollegeService")
public class AssociatecollegeServiceImpl implements AssociatecollegeService {
	@Autowired
	private AssociatecollegeDao associatecollegeDao;

	@Override
	public List<Associatecollege> getAllList() {
		List<Associatecollege> list = associatecollegeDao.getAllList();
		return list;
	}

	@Override
	public Associatecollege getAssociatecollegeByScanner(String type, String code) {
		Associatecollege associatecollege = associatecollegeDao.getAssociatecollegeByScanner(type, code);
		return associatecollege;
	}

}
