package swim.gdkm.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import swim.gdkm.interceptor.LoginInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	String[] exclude = { "/", "/login.html", "/css/**", "/img/**", "/js/**" };

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> testList = Arrays.asList(exclude);
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(testList);
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
