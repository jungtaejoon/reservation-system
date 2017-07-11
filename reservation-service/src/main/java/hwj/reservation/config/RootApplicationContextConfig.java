package hwj.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
		"hwj.reservation.dao",
		"hwj.reservation.service"
})
@Import({DbConfig.class})
public class RootApplicationContextConfig {

}
