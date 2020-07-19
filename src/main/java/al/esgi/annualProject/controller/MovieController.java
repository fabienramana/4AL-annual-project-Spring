package al.esgi.annualProject.controller;

import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.service.MovieService;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

import java.util.Optional;

@RestController
@RequestMapping(path="/movie")
public class MovieController {
    MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @RequestMapping(path="/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public Movie addNewMovie (@RequestBody Movie movie) {
        return movieService.addNewMovie(movie);
        
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    
    @GetMapping(path="/{id}")
    public Movie getMovieById(@PathVariable int id){
        return movieService.getMovieById(id);
    }

    @PutMapping(path="/{id}")
    public Movie modifyMovieAverageCommentNoteById(@PathVariable int id, @RequestBody Movie movie){
        return movieService.modifyMovieAverageCommentNoteById(id, movie);
    }
    
    @GetMapping(path="/get-api")
    public String getMoviesFromApi() throws IOException, InterruptedException {
        return movieService.getMoviesFromApi();
    }
    
}
