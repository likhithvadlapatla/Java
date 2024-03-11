package Service;

import Repository.UserRequest;

public interface UserService {
    User saveUser(UserRequest request) throws UserExistException;
    List<User> getAllUsers();

    User getUser(Integer id) throws UserNotFoundException;

    String deleteUser(Integer id) throws UserNotFoundException;

    User updateUser(UserRequest req) throws UserNotFoundException;
}
