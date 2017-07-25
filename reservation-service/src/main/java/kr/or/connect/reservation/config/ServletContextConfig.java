package kr.or.connect.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"kr.or.connect.reservation.controller",
})
public class ServletContextConfig extends WebMvcConfigurerAdapter{
	@Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(1);
        return viewResolver;
    }
	
	@Bean
	public HtmlViewResolver htmlViewResolver() {
		HtmlViewResolver htmlViewResolver = new HtmlViewResolver();
		htmlViewResolver.setViewClass(JstlView.class);	//이 부분 없으면 에러, 대체할 것없는지??
		htmlViewResolver.setPrefix("/resources/html/");
		htmlViewResolver.setOrder(2);
        return htmlViewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760); // 1024 * 1024 * 10
        return multipartResolver;
    }

	//welcome-file(초기 시작페이지 설정)
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/resources/html/mainpage.html");
    }

}
