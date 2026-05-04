package users.services;

import users.exceptions.UserAlreadyExistException;
import users.exceptions.UserNotFoundExeption;
import users.models.Permissions;
import users.models.User;
import users.repository.UserRepoSingleton;
import users.repository.UserRepository;
import users.repository.UserRepositoryImpl;

import java.security.Permission;

public class UserCommandServiceImpl implements UserCommandSerice {

    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserCommandServiceImpl() {
        this.userRepository = UserRepoSingleton.getInstance();
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        User existing = userRepository.findUserByEmail(user.getEmail());
        if (existing != null) {
            throw new UserAlreadyExistException();
        }
        return userRepository.saveUser(user);
    }

    @Override
    public User deleteUser(int id) throws UserNotFoundExeption {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new UserNotFoundExeption();
        }

        return userRepository.removeUser(user);
    }

    //validare exceptie -paznic sa nu ajunga gresit
    @Override
    public User addPermissionToUser(int id, Permissions permission) {
        return userRepository.addPermissonsToUser(id,permission);
    }

    @Override
    public User removePermissionFromUser(int id, Permissions permission) {

        return userRepository.removePermissonsFromUser(id,permission);
    }


}
