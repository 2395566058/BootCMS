package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 错误跳转页面
 */


@Controller
public class IndexController {
	@RequestMapping(value = "/error.action")
	public String toIndex(Model model) {
		model.addAttribute("msg", "找不到页面，返回登录页面！");
		return "Login.html";
	}

}
