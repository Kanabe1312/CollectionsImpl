package users.exceptions;

import app.system.Constants;

public class InvalidSubjectException extends RuntimeException {
    public InvalidSubjectException() {
        super(Constants.INVALID_SUBJECT);
    }
}
