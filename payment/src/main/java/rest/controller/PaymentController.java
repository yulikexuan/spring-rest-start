//: rest.controller.PaymentController.java


package rest.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.domain.model.Payment;
import rest.service.PaymentService;

import static rest.domain.model.Payment.PAID_HEADER_NAME;
import static rest.domain.model.Payment.PAYMENT_ID_HEADER_NAME;


@Slf4j
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{paymentId}")
    ResponseEntity<?> makePayment(
            @PathVariable @NonNull final String paymentId,
            @RequestBody @NonNull final Payment payment) {

        var paid = this.paymentService.processPayment(paymentId, payment);

        return ResponseEntity.status(HttpStatus.OK)
                .header(PAYMENT_ID_HEADER_NAME, paymentId)
                .header(PAID_HEADER_NAME, "true")
                .body(paid);
    }

}///:~