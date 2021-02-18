package exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExists extends Exception{
    public UserAlreadyExists(String message) {
        super(message);
    }


}
