//: rest.controller.advice.ControllerAdvice.java


package rest.controller.advice;


import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static rest.domain.model.Payment.PAID_HEADER_NAME;


@Slf4j
@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> handlePaymentProxyException(FeignException fe) {

        log.error(">>> Feign Exception : {}", fe.getMessage());

        return ResponseEntity.status(fe.status())
                .header(PAID_HEADER_NAME, "false")
                .body(fe.contentUTF8());
    }

}///:~