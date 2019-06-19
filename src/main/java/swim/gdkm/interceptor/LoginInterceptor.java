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
	/*
	 * 这里的数组是该项目所有被拦截页面
	 */
	private String[] interceptor = { "/ClassApply.action", "/Curriculum.action", "/Fix.action",
			"/StudentInformation.action", "/StudentList.action", "/Logout.action", "/StudentListScreen.action" };

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		if (url.indexOf("/Login.action") == 8) {
			// 访问主页，直接进入
			return true;
		}
		if (request.getSession().getAttribute("USER") != null) {
			// 已登录
			Sysuser sy = (Sysuser) request.getSession().getAttribute("USER");
			String authorization = sy.getUser_authorization();
			for (int i = 0; i < interceptor.length; i++) {
				if (url.indexOf(interceptor[i]) == 8) {
					if (authorization.equals("1")) {
						if (url.indexOf("/ClassApply.action") == 8 || url.indexOf("/Fix.action") == 8
								|| url.indexOf("/ClassApply.action") == 8) {
							// 权限不够
							request.setAttribute("msg", "你的权限不够！");
							request.getRequestDispatcher("/StudentList.action").forward(request, response);
							return false;
						}
					}
					return true;
				}
			}
			request.setAttribute("msg", "找不到该页面！");
			request.getRequestDispatcher("/StudentList.cation").forward(request, response);
		} else {
			// 未登录
			for (int i = 0; i < interceptor.length; i++) {
				if (url.indexOf(interceptor[i]) == 8) {
					request.setAttribute("msg", "登录后才允许访问！");
					request.getRequestDispatcher("/Login.action").forward(request, response);
					return false;
				}
			}
			request.setAttribute("msg", "找不到该页面！");
			request.getRequestDispatcher("/Login.action").forward(request, response);
			return false;
		}

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
