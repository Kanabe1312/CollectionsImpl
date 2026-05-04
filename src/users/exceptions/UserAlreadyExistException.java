package users.exceptions;

import app.system.Constants;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException() {
        super(Constants.USER_ALREADY_EXISTS);
    }
}
