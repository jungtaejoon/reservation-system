package won.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
		"won.reservation.dao",
		"won.reservation.service"
})
@Import({DbConfig.class})
public class RootApplicationContextConfig {
	
}
