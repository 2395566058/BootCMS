package swim.gdkm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import swim.gdkm.poji.Sysuser;

/*
 * 登录拦截器
 * 
 * */

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		System.out.println("拦截了路径=" + url);
		if (url.indexOf("/Login.action") == 8) {
			// 访问主页，直接进入
			return true;
		}
		if (url.equals("/BootCMS/")) {
			request.getRequestDispatcher("/Login.action").forward(request, response);
			return true;
		}
		if (request.getSession().getAttribute("USER") != null) {
			Sysuser sy = (Sysuser) request.getSession().getAttribute("USER");
			String authorization = sy.getUser_authorization();
			if (url.indexOf("BootCMS/error") < 0) {
				// 路径无误
				if (authorization.equals("1")) {
					if (url.indexOf("/ClassApply.action") == 8 || url.indexOf("/Fix.action") == 8
							|| url.indexOf("/ClassApply.action") == 8) {
						// 权限不够
						request.setAttribute("msg", "你的权限不够！");
						request.getRequestDispatcher("/StudentList.action").forward(request, response);
						return true;
					}
				}
				return true;
			}
			// 路径错误
			request.setAttribute("msg", "找不到该页面！");
			request.getRequestDispatcher("/StudentList.cation").forward(request, response);
		} else {
			// 未登录
			if (url.indexOf("BootCMS/error") < 0) {
				// 路径无误，不允许访问
				request.setAttribute("msg", "登录之后才能访问！");
				request.getRequestDispatcher("/Login.action").forward(request, response);
				return true;
			}
			request.setAttribute("msg", "找不到该页面！");
			request.getRequestDispatcher("/Login.action").forward(request, response);
			return true;
		}
		return true;
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
