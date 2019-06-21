package swim.gdkm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swim.gdkm.poji.Sysuser;
import swim.gdkm.service.SysuserService;
/*
 * 登录页面
 */

@Controller
public class LoginController {
	@Autowired
	private SysuserService sysuserService;

	@RequestMapping(value = "/Login.action", method = RequestMethod.GET)
	public String toLogin() {
		return "Login.html";
	}

	/*
	 * 登录判断
	 */

	@RequestMapping(value = "/Login.action", method = RequestMethod.POST)
	public String checkSysuser(String user_code, String user_password, HttpServletRequest request, Model model) {
		List<Sysuser> sys = sysuserService.getSysuserByScanner("user_code", user_code);
		if (sys != null) {
			for (int i = 0; i < sys.size(); i++) {
				if (sys.get(i).getUser_passowrd().equals(user_password)) {
					if (sys.get(i).getUser_state().equals("0")) {
						request.setAttribute("msg", "账号已被停用！");
						System.out.println("执行跳转");
						return "Login.html";
					}
					request.getSession().setAttribute("USER", sys.get(i));
					request.setAttribute("USER", sys.get(i));
					return "StudentList.html";
				}
				request.setAttribute("msg", "账号或密码错误！");
				return "Login.html";
			}
		}
		request.setAttribute("msg", "账号不存在！");
		return "Login.html";
	}

	/*
	 * 退出登录
	 */

	@RequestMapping(value = "/Logout.action", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "Login.action";
	}

}
