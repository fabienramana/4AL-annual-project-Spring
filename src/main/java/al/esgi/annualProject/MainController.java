package al.esgi.annualProject;

import al.esgi.annualProject.Models.User;
import al.esgi.annualProject.Models.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping("")
    public String helloWorld() {
        return "HelloWorld!";
    }

}
