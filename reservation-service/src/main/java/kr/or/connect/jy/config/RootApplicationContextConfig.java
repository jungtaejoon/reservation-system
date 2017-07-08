package kr.or.connect.jy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration //dao, service에 대한 컴포넌트를 scan한다. sevice는 미리 추가한다.
@ComponentScan(basePackages = {
		"kr.or.connect.jy.dao",
		"kr.or.connect.jy.service"
})
@Import({DbConfig.class})	// DBConfig를 설정한다.
public class RootApplicationContextConfig {
	
}
