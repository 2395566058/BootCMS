package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * 登录页面
 */

@Controller
public class LoginController {
	@RequestMapping(value = "/Login.action", method = RequestMethod.GET)
	public String toLogin(Model model) {
		return "Login.html";
	}
}
