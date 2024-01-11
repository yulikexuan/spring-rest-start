//: rest.service.InsufficientFundsException.java


package rest.service;


import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;


@Getter
@Accessors(fluent = true)
public class InsufficientFundsException extends RuntimeException {

    private final String accountId;

    public InsufficientFundsException(@NonNull final String accountId) {
        super();
        this.accountId = accountId;
    }

}///:~