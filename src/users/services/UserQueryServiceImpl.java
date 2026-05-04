package users.services;

import users.models.User;
import users.repository.UserRepoSingleton;
import users.repository.UserRepository;
import users.repository.UserRepositoryImpl;

import java.util.List;

public class UserQueryServiceImpl implements UserQueryService {

    UserRepository userRepository;

    public UserQueryServiceImpl() {
        this.userRepository = UserRepoSingleton.getInstance();
    }
    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public User getUsersByEmailandPassword(String email, String password) {
        return this.userRepository.findUserByEmailAndPassword(email, password);
    }



}
