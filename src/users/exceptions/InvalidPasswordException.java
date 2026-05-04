package users.exceptions;

import app.system.Constants;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super(Constants.INVALID_PASSWORD);
    }
}
