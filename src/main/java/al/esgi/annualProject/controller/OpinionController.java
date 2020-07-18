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

import java.util.List;
import java.util.Optional;

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
        Optional<User> user = userRepository.findByUserIdAndroid(opinion.getUserId());
        opinionRepository.save(opinion);
        return "Saved";
    }

    @GetMapping(path="/{id}")
    public Optional<Opinion> getOpinionById(@PathVariable int id){
        Optional<Opinion> opinion = opinionRepository.findById(id);
        return opinion;
    }
    
    @GetMapping(path="/movie/{id}")
    public List<Opinion> getOpinionsByMovie(@PathVariable int id){
        Movie movie = movieRepository.getOne(id);
        List<Opinion> opinions = opinionRepository.findByMovieId(id);
        return opinions;
    }

    @GetMapping(path="/user/{id}")
    public List<Opinion> getOpinionsByUser(@PathVariable String id){
        Optional<User> user = userRepository.findByUserIdAndroid(id);
        List<Opinion> opinions = opinionRepository.findByUserId(user.get().getUserIdAndroid());
        return opinions;
    }
    
    @GetMapping(path="/last")
    public Opinion getLastOpinion(){
        return opinionRepository.findFirstByOrderByIdDesc();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Opinion> getAllMovies() {
        // This returns a JSON or XML with the users
        return opinionRepository.findAll();
    }
}
