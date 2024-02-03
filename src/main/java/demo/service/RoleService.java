package demo.service;

import demo.model.Role;

import java.util.List;

public interface RoleService {
    Role getRole(String userRole);

    List<Role> getAllRole();

    Role getRole(long roleId);

    void addRole(Role role);
}
