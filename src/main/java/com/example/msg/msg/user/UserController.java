package com.example.msg.msg.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getPessoas() 
    {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User findByIdentifier(@PathVariable String id) 
    {
        return userService.findByIdentifier(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User salvarUser(@RequestBody @Valid User user) 
    {
        return userService.salvarUser(user);
    }

}
