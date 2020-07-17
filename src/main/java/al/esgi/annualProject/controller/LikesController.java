package al.esgi.annualProject.controller;

import al.esgi.annualProject.models.Likes;
import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.models.User;
import al.esgi.annualProject.repository.LikesRepository;
import al.esgi.annualProject.repository.MovieRepository;
import al.esgi.annualProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/like")
public class LikesController {
    @Autowired
    LikesRepository likesRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;
    
    @PostMapping(path="/yes")
    public String addNewLike(@RequestBody Likes like){
        Movie movie = movieRepository.getOne(like.getMovieId());
        User user = userRepository.getOne(like.getUserId());
        likesRepository.save(like);
        return "Saved";
    }
    
}
