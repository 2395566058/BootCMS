package swim.gdkm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import swim.gdkm.poji.Sys_user;

/*
 * 登录拦截器
 * 
 * */

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		if (url.indexOf("/login.action") >= 0) {
			System.out.println("拦截了路径:" + url+"    通过");
			return true;
		}
		HttpSession session = request.getSession();
		Sys_user user = (Sys_user) session.getAttribute("USER_SESSION");
		if (user != null) {
			System.out.println("拦截了路径:" + url+"    通过");
			return true;
		}
		request.setAttribute("msg", "您还没有登录，请先登录!");
		request.getRequestDispatcher("/error.action").forward(request, response);
		System.out.println("拦截了路径:" + url+"    不通过，执行跳转");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
