package users.exceptions;

import app.system.Constants;

public class InvalidLevelException extends RuntimeException {
    public InvalidLevelException() {
        super(Constants.INVALID_LEVEL);
    }
}
