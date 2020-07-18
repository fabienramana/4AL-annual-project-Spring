package al.esgi.annualProject.controller;


import al.esgi.annualProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import al.esgi.annualProject.repository.UserRepository;
import al.esgi.annualProject.models.User;

@RestController 
@RequestMapping(path = "/user") 
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/add")
    public String addNewUser(@RequestBody User u) {
        return userService.addNewUser(u);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
