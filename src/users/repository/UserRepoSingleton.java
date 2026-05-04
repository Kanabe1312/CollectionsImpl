package users.repository;

public class UserRepoSingleton {

    private static final UserRepository instance = new UserRepositoryImpl();

    public static UserRepository getInstance() {
        return instance;
    }
}