package kr.or.connect.reservation.connect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import kr.or.connect.reservation.config.Dbconfig;



@Configuration
//dao, service에 대한 컴포넌트를 scan한다. sevice는 미리 추가한다.
@ComponentScan(basePackages = {
		  "kr.or.connect.reservation.dao",
		  "kr.or.connect.reservation.service"
		  //,"kr.or.config"
})

@Import({Dbconfig.class})
public class RootApplicationContextConfig{

}
