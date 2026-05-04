package users.exceptions;

import app.system.Constants;

public class InvalidUserTypeException extends RuntimeException {
    public InvalidUserTypeException() {
        super(Constants.INVALIDE_USER_TYPE);
    }
}
