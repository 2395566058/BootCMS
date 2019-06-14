package swim.gdkm.dao;

import org.apache.ibatis.annotations.Param;

import swim.gdkm.poji.Sys_user;

public interface UserDao {
	public Sys_user findUser(@Param("user_code") String user_code, @Param("user_password") String user_password);
}
