package demo.dao;


import demo.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getAllRole();

    Role getRole(String userRole);

    Role getRole(long roleId);

    void addRole(Role role);
}
