package com.soomin.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"com.soomin.reservation.dao", "com.soomin.reservation.service"})
@Import({DbConfig.class})
public class RootApplicationContextConfig {

}
