package swim.gdkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * 学生列表页面
 */

@Controller
public class StudentListController {
	@RequestMapping(value = "/StudentList.action", method = RequestMethod.GET)
	public String toLogin(Model model) {
		return "StudentList.html";
	}
}
