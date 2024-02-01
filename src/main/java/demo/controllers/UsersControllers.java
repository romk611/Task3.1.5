package demo.controllers;



import demo.model.User;
import demo.service.RoleService;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;

@Controller
public class UsersControllers {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UsersControllers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String start() {
        return "redirect:/admin";
    }


    @GetMapping("/user")
    public String getUser(Principal principal, Model model) {
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "/user";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "logout", required = false) String logout,
                                        Model model) {
        model.addAttribute("logout", logout != null);
        return "login";

    }
}
