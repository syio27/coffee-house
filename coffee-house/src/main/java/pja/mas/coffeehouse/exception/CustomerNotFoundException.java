package pja.mas.coffeehouse.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1772348013226024884L;
    private final Long id;

    public CustomerNotFoundException(Long id) {
        super(String.format("DOEST EXIST! - Customer with id %s not found", id));
        this.id = id;
    }
}
