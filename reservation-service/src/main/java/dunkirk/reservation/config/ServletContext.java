package dunkirk.reservation.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"dunkirk.reservation.controller",
		"dunkirk.reservation.api"
})
@PropertySource("classpath:/application.properties")
public class ServletContext extends WebMvcConfigurerAdapter {
	
	@Value("${resource.handler}")
	private String resourceHandler;

	@Value("${resource.location}")
	private String resourceLocation;
	
	@Value("${viewResolver.prefix}")
	private String viewResolverPrefix;
	
	@Value("${viewResolver.suffix}")
	private String viewResolverSuffix;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(resourceHandler).addResourceLocations(resourceLocation);
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(viewResolverPrefix, viewResolverSuffix);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	
}
