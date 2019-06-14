package swim.gdkm.service;

import swim.gdkm.poji.Sys_user;

public interface UserService {
	public Sys_user findUser(String user_code,String user_password);
}
