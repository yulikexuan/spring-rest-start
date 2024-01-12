//: rest.config.RestAppConfig.java


package rest.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {
        "rest.controller",
        "rest.controller.advice",
        "rest.service"})
@EnableFeignClients(basePackages = "rest.client.proxy")
class RestClientAppConfig {

}///:~