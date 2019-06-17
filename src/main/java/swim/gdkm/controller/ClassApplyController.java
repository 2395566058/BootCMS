package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 教室申请受理页面
 */

@Controller
public class ClassApplyController {
	@RequestMapping(value = "/ClassApply.action", method = RequestMethod.GET)
	public String toLogin(Model model) {
		return "ClassApply.html";
	}
}
