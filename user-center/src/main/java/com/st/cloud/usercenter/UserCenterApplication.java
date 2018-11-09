package com.st.cloud.usercenter;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 枫竹
 * @version V1.0.0
 * @Title: UserCenterApplication
 * @Package com.st.cloud.usercenter
 * @date 2018/11/8 19:29
 */
@EnableSwagger2Doc
@EnableEurekaClient
@SpringBootApplication
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
