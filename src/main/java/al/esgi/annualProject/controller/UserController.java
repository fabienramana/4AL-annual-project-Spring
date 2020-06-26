package al.esgi.annualProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import al.esgi.annualProject.utils.BCryptManagerUtil;
import org.json.JSONObject;

import al.esgi.annualProject.repository.UserRepository;
import al.esgi.annualProject.models.User;

@RestController // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public String addNewUser (@RequestBody String u) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        JSONObject jsonObject = new JSONObject(u);
        User user = new User(jsonObject.getString("username"), jsonObject.getString("password"),
                jsonObject.getString("firstname"), jsonObject.getString("lastname"));
        userRepository.save(user);
        return "Saved";
    }

    @PostMapping(path="/login")
    public String login(@RequestBody String u) {
        JSONObject jsonObject = new JSONObject(u);
        User user = userRepository.findByUsername(jsonObject.getString("username"));
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if(bcrypt.matches(jsonObject.getString("password"), user.getPassword())){
            return "Access Permitted";
        }
        return "Access denied";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
