package users.exceptions;

import app.system.Constants;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
        super(Constants.INVALID_ID);
    }
}
