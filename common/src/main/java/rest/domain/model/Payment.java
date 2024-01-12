//: rest.domain.model.PaymentDetails.java


package rest.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
@Getter(onMethod = @__(@JsonProperty))
@Setter(onMethod = @__(@JsonProperty))
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Payment {

    public static final String PAID_HEADER_NAME = "paid";
    public static final String PAYMENT_ID_HEADER_NAME = "payment_id";

    String account;
    long amount;

    public static Payment of(@NonNull final Payment payment) {
        return Payment.of(payment.account(), payment.amount());
    }

}///:~