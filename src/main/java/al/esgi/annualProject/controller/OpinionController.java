package al.esgi.annualProject.controller;

import al.esgi.annualProject.models.Likes;
import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.models.Opinion;
import al.esgi.annualProject.models.User;
import al.esgi.annualProject.repository.MovieRepository;
import al.esgi.annualProject.repository.OpinionRepository;
import al.esgi.annualProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/opinion")
public class OpinionController {
    @Autowired
    private OpinionRepository opinionRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping(path="/add")
    public String addNewOpinion(@RequestBody Opinion opinion){
        Movie movie = movieRepository.getOne(opinion.getMovieId());
        User user = userRepository.findByUserIdAndroid(opinion.getUserId());
        opinionRepository.save(opinion);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Opinion> getAllMovies() {
        // This returns a JSON or XML with the users
        return opinionRepository.findAll();
    }
}
