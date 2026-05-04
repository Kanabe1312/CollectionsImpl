package users.exceptions;

import app.system.Constants;

public class InvalidBirthdayException extends RuntimeException {

    public InvalidBirthdayException() {
        super(Constants.INVALID_BIRTHDAY);
    }
}
