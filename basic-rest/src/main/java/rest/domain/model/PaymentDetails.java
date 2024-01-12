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
public class PaymentDetails {

    long amount;

}///:~