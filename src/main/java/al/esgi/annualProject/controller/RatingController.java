package al.esgi.annualProject.controller;

import al.esgi.annualProject.models.Commentaries;
import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.models.Rating;
import al.esgi.annualProject.models.User;
import al.esgi.annualProject.repository.MovieRepository;
import al.esgi.annualProject.repository.RatingRepository;
import al.esgi.annualProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/rating")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public String addNewRating (@RequestBody Rating rating) {
        Optional<Movie> movie = movieRepository.findById(rating.getMovieId());
        Optional<User> user = userRepository.findById(rating.getUserId());
        Rating newRating = new Rating(rating.getNote(), movie.get().getId(), user.get().getId());
        ratingRepository.save(rating);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Rating> getAllRatings() {
        // This returns a JSON or XML with the users
        return ratingRepository.findAll();
    }
}
