package users.exceptions;

import app.system.Constants;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super(Constants.INVALID_EMAIL);
    }
}
