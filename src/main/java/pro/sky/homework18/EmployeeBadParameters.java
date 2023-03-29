package pro.sky.homework18;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class EmployeeBadParameters extends RuntimeException{
    public EmployeeBadParameters() {
    }

    public EmployeeBadParameters(String message) {
        super(message);
    }
}
