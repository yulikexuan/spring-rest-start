//: rest.controller.advice.AppAdvice.java


package rest.controller.advice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rest.domain.model.PaymentErrorDetails;
import rest.service.InsufficientFundsException;

import static rest.domain.model.Payment.PAID_HEADER_NAME;


@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<PaymentErrorDetails> handleInsufficientFunds(
            InsufficientFundsException e) {

        var errDetails = PaymentErrorDetails.of(
                ">>> Not enough money in account %s to make the payment for %s!"
                        .formatted(e.accountId(), e.paymentId()));

        return ResponseEntity.badRequest()
                .header(PAID_HEADER_NAME, "false")
                .body(errDetails);
    }

}///:~