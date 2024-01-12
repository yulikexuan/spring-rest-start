//: rest.domain.model.ErrorDetails.java


package rest.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@Getter(onMethod = @__(@JsonProperty))
@AllArgsConstructor(staticName = "of")
public class PaymentErrorDetails {

    String message;

}///:~