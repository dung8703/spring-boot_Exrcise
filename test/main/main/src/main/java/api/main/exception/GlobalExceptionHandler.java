package api.main.exception;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//GlobalExceptionHandler
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(NotFoundException exception){
        BaseErrorDetail errorDetail = new BaseErrorDetail(HttpStatus.NOT_FOUND,LocalDateTime.now(),exception.getDescription());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetail);
    }
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<?> handleInternalServerErrorException(InternalServerException exception){
        BaseErrorDetail errorDetail = new BaseErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR,LocalDateTime.now(),exception.getDescription());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetail);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestExcep(BadRequestException exception){
        BaseErrorDetail errorDetail = new BaseErrorDetail(HttpStatus.BAD_REQUEST,LocalDateTime.now(),exception.getDescription());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetail);
    }
}
