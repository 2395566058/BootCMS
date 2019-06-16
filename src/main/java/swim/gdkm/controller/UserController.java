package swim.gdkm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import swim.gdkm.poji.Sys_user;
import swim.gdkm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String usercode, String password, Model model, HttpSession session) {
		Sys_user user = userService.findUser(usercode, password);
		if (user != null) {
			session.setAttribute("USER_SESSION", user);
			return "customer.html";
		}
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
		return "login.html";
	}

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String toLogin() {
		return "login.html";
	}

	/**
	 * 跳转到客户管理页面
	 */
	@RequestMapping(value = "/toCustomer.action")
	public String toCustomer() {
		return "customer.html";
	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.action";
	}
}
