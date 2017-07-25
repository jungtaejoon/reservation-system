package kr.or.connect.reservation.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {
        "kr.or.connect.reservation.dao",
        "kr.or.connect.reservation.service"
})
@Import({DbConfig.class}) // DBConfig 를 설정한다.
public class RootApplicationContextConfig {
	// 나중에 추가
	
	@Bean
	public RestTemplate restTemplate() {
		
		
	    
	    RestTemplate restTemplate = new RestTemplate();
	    
	    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	    requestFactory.setReadTimeout(5000);
	    requestFactory.setConnectTimeout(5000);
	    
	    restTemplate.setRequestFactory(requestFactory);

	    
	    
	    HttpMessageConverter<?> formHttpMessageConverter = new FormHttpMessageConverter();
	    StringHttpMessageConverter stringMessageConverter = new StringHttpMessageConverter( Charset.forName( "UTF-8" ) );
	    MappingJackson2HttpMessageConverter jackson2Converter = new MappingJackson2HttpMessageConverter();
	    
	    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	    messageConverters.add(formHttpMessageConverter);
	    messageConverters.add(stringMessageConverter);
	    messageConverters.add(jackson2Converter);

	    restTemplate.setMessageConverters(messageConverters);
	    
	    return restTemplate;
	}
}


