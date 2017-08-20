package dunkirk.reservation.config;

import org.springframework.context.annotation.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {
        "dunkirk.reservation.dao",
        "dunkirk.reservation.service",
        "dunkirk.reservation.util"
})
@Import({DbConfig.class})
public class RootApplicationContext {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }
}
