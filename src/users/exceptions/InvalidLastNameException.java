package users.exceptions;

import app.system.Constants;

public class InvalidLastNameException extends RuntimeException {
    public InvalidLastNameException() {
        super(Constants.INVALID_LAST_NAME);
    }
}
