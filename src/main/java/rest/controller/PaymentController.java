//: rest.controller.PaymentController.java


package rest.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.domain.model.PaymentDetails;
import rest.service.PaymentService;


@Slf4j
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    ResponseEntity<?> makePayment(
            @NonNull final @RequestBody PaymentDetails paymentDetails) {

        final var amount = paymentDetails.amount();
        log.info(">>> Request to pay amount: {}", amount);

        var payment = this.paymentService.processPayment(paymentDetails);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(payment);
    }

}///:~