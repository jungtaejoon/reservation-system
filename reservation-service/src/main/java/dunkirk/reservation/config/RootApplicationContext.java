package dunkirk.reservation.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {
		"dunkirk.reservation.dao",
		"dunkirk.reservation.service"
})
@Import({DbConfig.class})
public class RootApplicationContext {

}
