package com.st.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger文档显示类
 * 自动检查Eureka上可用服务，将对应Swagger统一集成到Zuul上
 *
 * @author 枫竹
 * @version V1.0.0
 * @Title: DocumentationConfig
 * @Package com.st.gateway.config
 * @date 2018/11/9 16:03
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取注册中心的服务
     *
     * @return
     */
    @Override
    public List<SwaggerResource> get() {
        List<String> services = discoveryClient.getServices();
        List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
        if (CollectionUtils.isEmpty(services)) {
            return resources;
        }
        for (String s : services) {
            resources.add(swaggerResource(s, "/" + s + "/v2/api-docs", "2.0"));
        }
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
