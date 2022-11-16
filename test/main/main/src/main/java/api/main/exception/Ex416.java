package api.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.Getter;
@Getter
@ResponseStatus(value = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
public class Ex416 extends RuntimeException {
    private String description;
    public Ex416(String description) {
        super("Requested Range Not Satisfiable");
        this.description = description;
    }
}
