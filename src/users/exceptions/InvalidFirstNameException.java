package users.exceptions;

import app.system.Constants;

public class InvalidFirstNameException extends RuntimeException {
    public InvalidFirstNameException() {
        super(Constants.INVALID_FIRST_NAME);
    }
}
