package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value="/error.action")
	public String toIndex() {
		return "login.html";
	}

}
