package dunkirk.reservation.config;

import org.springframework.context.annotation.*;
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
        return restTemplate;
    }
}
