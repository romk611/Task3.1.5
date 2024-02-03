package demo.dao;


import demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();

    User getUserById(long id);

    void saveUser(User user);

    void editUser(User user);

    void deleteUser(long id);

    User getUserByUsername(String username);
}
