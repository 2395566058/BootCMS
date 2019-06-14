package swim.gdkm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swim.gdkm.dao.UserDao;
import swim.gdkm.poji.Sys_user;
import swim.gdkm.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;

	@Override
	public Sys_user findUser(String user_code, String user_password) {
		Sys_user user = new Sys_user();
		user = this.userdao.findUser(user_code, user_password);
		return user;
	}

}
