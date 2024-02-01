package demo.dao;


import demo.model.User;

import java.util.Set;

public interface UserDAO {
    public Set<User> getAllUser();
    public User getUserById(long id);
    public void saveUser(User user);
    public void editUser(User user);
    public void deleteUser(long id);
    public User getUserByUsername(String username);
}
