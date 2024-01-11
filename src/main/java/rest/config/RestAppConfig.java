//: rest.config.RestAppConfig.java


package rest.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import rest.service.PaymentService;


@Configuration
@ComponentScan(basePackages = {
        "rest.controller", "rest.controller.advice", "rest.service"})
class RestAppConfig {

    @Bean
    PaymentService paymentService() {
        return PaymentService.newPaymentService();
    }

}///:~