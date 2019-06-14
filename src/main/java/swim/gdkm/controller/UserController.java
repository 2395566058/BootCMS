package swim.gdkm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import swim.gdkm.poji.Sys_user;
import swim.gdkm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login.action")
	public String login(String usercode, String password, Model model, HttpSession session) {
		System.out.println("访问了控制器：" + this.toString());
		Sys_user user = userService.findUser(usercode, password);
		if (user != null) {
			session.setAttribute("USER_SESSION", user);
			return "customer";
		}
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
		return "login.html";
	}
}
