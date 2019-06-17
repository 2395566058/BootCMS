package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 处理报修页面
 */

@Controller
public class FixController {
	@RequestMapping(value = "/Fix.action", method = RequestMethod.GET)
	public String toLogin(Model model) {
		return "Fix.html";
	}
}
