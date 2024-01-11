//: rest.service.PaymentService


package rest.service;


import lombok.extern.slf4j.Slf4j;
import rest.domain.model.PaymentDetails;

import java.util.UUID;


public interface PaymentService {

    long FUNDS = 1000;

    PaymentDetails processPayment(PaymentDetails paymentDetails);

    static PaymentService newPaymentService() {
        return new PaymentServiceImpl();
    }
}

@Slf4j
final class PaymentServiceImpl implements PaymentService {

    public PaymentDetails processPayment(
            PaymentDetails paymentDetails) {

        if (paymentDetails.amount() > FUNDS) {
            throw new InsufficientFundsException(UUID.randomUUID().toString());
        }

        return PaymentDetails.of(paymentDetails.amount());
    }

}

///:~