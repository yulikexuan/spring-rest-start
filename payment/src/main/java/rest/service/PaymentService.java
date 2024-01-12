//: rest.service.PaymentService


package rest.service;


import lombok.extern.slf4j.Slf4j;
import rest.domain.model.Payment;

import java.util.UUID;


public interface PaymentService {

    long LIMIT = 20000;

    Payment processPayment(String paymentId, Payment payment);

    static PaymentService newPaymentService() {
        return new PaymentServiceImpl();
    }
}

@Slf4j
final class PaymentServiceImpl implements PaymentService {

    public Payment processPayment(String paymentId, Payment payment) {

        if (payment.amount() > LIMIT) {
            throw new InsufficientFundsException(paymentId, payment.account());
        }

        return Payment.of(payment);
    }

}

///:~