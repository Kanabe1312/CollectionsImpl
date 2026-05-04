package users.exceptions;

import app.system.Constants;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption() {
        super(Constants.USER_NOT_FOUND);
    }
}
