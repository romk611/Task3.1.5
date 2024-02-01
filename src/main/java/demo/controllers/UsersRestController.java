package demo.controllers;

import demo.model.User;
import demo.service.RoleService;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@RequestMapping("/one")
@RestController
public class UsersRestController {


    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UsersRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity <User> user(Principal principal) {
        return new ResponseEntity <> (userService.getUserByUsername(principal.getName()), HttpStatus.OK);
    }
}
