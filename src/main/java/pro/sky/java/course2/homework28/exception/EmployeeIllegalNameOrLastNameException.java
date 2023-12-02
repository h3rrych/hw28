package pro.sky.java.course2.homework28.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EmployeeIllegalNameOrLastNameException extends RuntimeException {
    public EmployeeIllegalNameOrLastNameException(String message) {
        super(message);
    }
}
