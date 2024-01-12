//: rest.domain.model.Country.java


package rest.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
@Getter(onMethod = @__(@JsonProperty))
public class Country {

    String name;
    int population;

}///:~