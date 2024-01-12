//: rest.controller.PaymentController.java


package rest.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.client.proxy.PaymentClientProxy;
import rest.domain.model.Payment;

import static rest.domain.model.Payment.PAID_HEADER_NAME;
import static rest.domain.model.Payment.PAYMENT_ID_HEADER_NAME;


@Slf4j
@RestController
@RequestMapping("/client/payment")
@RequiredArgsConstructor
class ClientPaymentController {

    private final PaymentClientProxy paymentClientProxy;

    @PostMapping("/{paymentId}")
    ResponseEntity<?> makePayment(
            @PathVariable("paymentId") @NonNull final String paymentId,
            @RequestBody @NonNull final Payment payment) {

        ResponseEntity<Payment> processedPayment =
                this.paymentClientProxy.makePayment(paymentId, payment);

        var headers = processedPayment.getHeaders();

        String paymentIdHeader = headers
                .getValuesAsList(PAYMENT_ID_HEADER_NAME)
                .get(0);

        String paidHeader = headers
                .getValuesAsList(PAID_HEADER_NAME)
                .get(0);

        log.info(">>> Payment Id in Header: {}", paymentIdHeader);
        log.info(">>> Is Paid? {}", paidHeader);

        return ResponseEntity.status(HttpStatus.OK)
                .header(PAYMENT_ID_HEADER_NAME, paymentIdHeader)
                .header(PAID_HEADER_NAME, paidHeader)
                .body(processedPayment.getBody());
    }

}///:~