package demo.dao;


import demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    public Set<Role> getAllRole();

    public Role getRole(String userRole);

    public Role getRole(long roleId);

    public void addRole(Role role);
}
