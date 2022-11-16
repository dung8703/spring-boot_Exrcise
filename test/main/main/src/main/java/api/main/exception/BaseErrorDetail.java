package api.main.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseErrorDetail {
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    public BaseErrorDetail(HttpStatus status, LocalDateTime timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }   
}
