package kr.or.connect.config;

import org.springframework.context.annotation.*;

@Configuration
// dao, service에 대한 컴포넌트를 scan한다. sevice는 미리 추가한다.
@ComponentScan(basePackages = {
        "kr.or.connect.dao",
        "kr.or.connect.serviceImpl",
        "kr.or.connect.util"
})
@Import({DbConfig.class}) // DBConfig 를 설정한다.
public class RootApplicationContextConfig {
}