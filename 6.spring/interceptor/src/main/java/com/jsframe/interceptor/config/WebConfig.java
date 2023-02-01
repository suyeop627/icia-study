package com.jsframe.interceptor.config;

import com.jsframe.interceptor.util.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired // 세션인터셉터에 @Component를 써서 사용 가능해짐
    SessionInterceptor interceptor;

    @Override //add만 쓰면 자동완성 됨
    public void addInterceptors(InterceptorRegistry registry) {
        //세션 인터셉터를 스프링 프레임워크에 등록
        registry.addInterceptor(interceptor) //경로 지정할때는 앞에 /(루트)써줌
                .addPathPatterns("/**") //모든 url을 인터셉트

                //선택한 경로 제외(exclude)
                // ,로 구분해서 여러개넣기 가능, css, js등도 걸리기때문에 예외로 설정
                .excludePathPatterns("/", "/css/**", "/js/**")
                // html, 안에서 매핑한 proc도 같이 예외로 등록해야됨
                .excludePathPatterns("/loginFrm", "/loginProc")


        ;
    }
}
