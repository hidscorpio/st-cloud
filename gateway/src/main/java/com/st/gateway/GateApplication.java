package com.st.gateway;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Gate
 *
 * @author 枫竹
 * @version V1.0.0
 * @Title: GateApplication
 * @Package com.st.gateway
 * @date 2018/11/9 15:51
 */
@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class GateApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateApplication.class, args);
    }
}
