//: rest.proxy.PaymentsProxy


package rest.client.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rest.domain.model.Payment;


@FeignClient(name = "payments", url="${payment.service.url}")
public interface PaymentClientProxy {

    @PostMapping("/payment/{paymentId}")
    ResponseEntity<Payment> makePayment(
            @PathVariable("paymentId") String paymentId,
            @RequestBody Payment payment);

}///:~