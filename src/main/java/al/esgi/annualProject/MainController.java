package al.esgi.annualProject;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping("")
    public String helloWorld() {
        return "HelloWorld!";
    }

}
