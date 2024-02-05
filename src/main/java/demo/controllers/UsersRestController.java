package demo.controllers;

import demo.model.User;
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
    @Autowired
    public UsersRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity <User> user(Principal principal) {
        return new ResponseEntity <> (userService.getUserByUsername(principal.getName()), HttpStatus.OK);
    }
}
