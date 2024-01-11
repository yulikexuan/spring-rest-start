//: rest.controller.advice.AppAdvice.java


package rest.controller.advice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rest.domain.model.PaymentErrorDetails;
import rest.service.InsufficientFundsException;


@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<PaymentErrorDetails> handleInsufficientFunds(
            InsufficientFundsException e) {

        var errDetails = PaymentErrorDetails.of(
                ">>> Not enough money in account %s to make the payment!"
                        .formatted(e.accountId()));

        return ResponseEntity.badRequest().body(errDetails);
    }

}///:~