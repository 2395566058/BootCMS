package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private static final String INDEX = "login";

	@RequestMapping("/")
	public String getIndex() {
		System.out.println(INDEX);
		return INDEX;
	}
}
