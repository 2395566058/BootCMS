package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 课程列表页面
 */


@Controller
public class CurriculumController {
	@RequestMapping(value = "/Curriculum.action", method = RequestMethod.GET)
	public String toLogin(Model model) {
		return "Curriculum.html";
	}
}
