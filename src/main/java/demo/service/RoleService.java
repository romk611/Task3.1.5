package demo.service;

import demo.dao.RoleDAO;
import demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    private final RoleDAO roleDAO;

    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public Role getRole(String userRole) {
        return roleDAO.getRole(userRole);
    }

    public Set<Role> getAllRole() {
        return roleDAO.getAllRole();
    }

    public Role getRole(long roleId) {
        return roleDAO.getRole(roleId);
    }

    @Transactional
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }
}
