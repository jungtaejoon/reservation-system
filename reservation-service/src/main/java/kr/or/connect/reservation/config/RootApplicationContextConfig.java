package kr.or.connect.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

//dao, service에 대한 컴포넌트를 scan한다. sevice는 미리 추가한다.
//bean 들을 미리 등록해준다
@ComponentScan(basePackages = {
  "kr.or.connect.reservation.dao",
  "kr.or.connect.reservation.service"
})

@Import({DbConfig.class}) // DBConfig 를 설정한다.
public class RootApplicationContextConfig {

}
