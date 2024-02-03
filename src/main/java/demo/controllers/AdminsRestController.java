package demo.controllers;

import demo.model.User;
import demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@RestController

public class AdminsRestController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AdminsRestController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/users")
    public ResponseEntity <List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity <User> getUser(@PathVariable int id) {
        return new ResponseEntity<> (userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity <User> update(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.editUser(user);
        return new ResponseEntity<> (user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity <User> newUser(@RequestBody @Valid User user) {
        if (user.getRoles().isEmpty()) {
            return new ResponseEntity<> (user, HttpStatus.OK);
        }
        if (userService.getUserByUsername(user.getEmail()) == User.NOBODY) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
        }
        return new ResponseEntity<> (user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
