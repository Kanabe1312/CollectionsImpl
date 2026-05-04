package users.exceptions;

import app.system.Constants;

public class InvalidProgressException extends RuntimeException {
    public InvalidProgressException() {
        super(Constants.INVALIDE_PROGRESS);
    }
}
