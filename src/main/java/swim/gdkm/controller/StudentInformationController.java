package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 学生详细信息页面
 */

@Controller
public class StudentInformationController {
	@RequestMapping(value = "/StudentInformation.action", method = RequestMethod.GET)
	public String toLogin(Model model) {
		return "StudentInformation.html";
	}
}
