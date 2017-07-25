package kr.or.connect.config;

import org.springframework.context.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.multipart.*;
import org.springframework.web.multipart.commons.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.or.connect.controller","kr.or.connect.api"})
public class ServletContextConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");  //   webapp/resources 경로를 의미
        registry.addResourceHandler("/node_modules/**").addResourceLocations("/node_modules/"); 
    }
    
    @Bean
    public MultipartResolver multipartResolver() {
    	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760);
        return multipartResolver;
    }
    
    @Bean
    public RestTemplate restTemplate() {
    	RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}