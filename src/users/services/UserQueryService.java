package users.services;

import users.models.User;

import java.util.List;

public interface UserQueryService {

    List<User> getUsers();

    User getUsersByEmailandPassword(String email, String password);



}
