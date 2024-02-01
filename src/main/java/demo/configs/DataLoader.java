package demo.configs;


import demo.model.Role;
import demo.model.User;
import demo.service.RoleService;
import demo.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder encoder;

    public DataLoader(UserService userService, RoleService roleService, PasswordEncoder encoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    public void run(ApplicationArguments args) {

        if (roleService.getRole("ROLE_USER") == Role.NOBODY) {
            roleService.addRole(new Role("ROLE_USER"));
        }

        if (roleService.getRole("ROLE_ADMIN") == Role.NOBODY) {
            roleService.addRole(new Role("ROLE_ADMIN"));
        }

        if (userService.getUserByUsername("admin@mail.ru") == User.NOBODY) {
            User ivan = new User("admin@mail.ru", encoder.encode("admin")
                    , "Roman", "Shamsiev", (byte)65);
            ivan.setRole(roleService.getRole("ROLE_ADMIN"));
            ivan.setRole(roleService.getRole("ROLE_USER"));
            userService.saveUser(ivan);
        }

        if (userService.getUserByUsername("user@mail.ru") == User.NOBODY) {
            User petr = new User("user@mail.ru", encoder.encode("user")
                    , "Ivan","Ivanov", (byte)24);
            petr.setRole(roleService.getRole("ROLE_USER"));
            userService.saveUser(petr);
        }
    }
}
