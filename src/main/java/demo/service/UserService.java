package demo.service;

import demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserById(long id);

    void saveUser(User user);

    void editUser(User user);

    void deleteUser(long id);

    User getUserByUsername(String email);
}
