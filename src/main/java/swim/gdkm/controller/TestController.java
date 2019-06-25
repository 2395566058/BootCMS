package swim.gdkm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swim.gdkm.poji.Sysuser;
import swim.gdkm.service.SysuserService;

@Controller
public class TestController {
	@Autowired
	private SysuserService sysuserService;

	@RequestMapping(value = "/Test.action", method = RequestMethod.POST)
	public String goTO(HttpServletRequest request,HttpServletResponse response) {
		List<Sysuser> sys = sysuserService.getSysuserByScanner("user_code", "root");
		request.getSession().setAttribute("USER", sys.get(0));
		return "/StudentList.action";
	}
}
