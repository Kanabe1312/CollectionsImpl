package users.services;

import users.exceptions.UserAlreadyExistException;
import users.exceptions.UserNotFoundExeption;
import users.models.Permissions;
import users.models.User;

import java.security.Permission;

public interface UserCommandSerice {

    User addUser(User user);

    User deleteUser(int id);

    User addPermissionToUser(int id, Permissions permission);

    User removePermissionFromUser(int id, Permissions permission);

}
