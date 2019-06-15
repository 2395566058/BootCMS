package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/*
	 * 默认页面
	 * 
	 */

	@RequestMapping("/")
	public String getIndex() {
		return "login.html";
	}
}
