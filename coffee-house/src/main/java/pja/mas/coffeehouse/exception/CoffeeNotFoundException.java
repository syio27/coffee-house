package pja.mas.coffeehouse.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CoffeeNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -7615598787490340864L;
    private final Long id;

    public CoffeeNotFoundException(Long id) {
        super(String.format("DOEST EXIST! - Coffee with id %s not found", id));
        this.id = id;
    }
}
