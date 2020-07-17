package al.esgi.annualProject.controller;

import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.repository.MovieRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import java.util.Optional;

@RestController
@RequestMapping(path="/movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;
    
    public String apiKey = "e80ae4cad06b931beaa5b7f21ea45904";

    @RequestMapping(path="/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public String addNewMovie (@RequestBody Movie movie) {
        movieRepository.save(movie);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        // This returns a JSON or XML with the users
        return movieRepository.findAll();
    }
    
    @GetMapping(path="/get-api")
    public String getMoviesFromApi() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/now_playing?api_key="+ apiKey))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        System.out.println(response.body());
        //return response.body();
        JSONObject json = new JSONObject(response.body());
        JSONArray results = json.getJSONArray("results");
        StringBuilder str = new StringBuilder();
        Movie movie;
        for (Object o : results) {
            
            JSONObject result = (JSONObject) o;
            String title = result.getString("title");
            String description = result.getString("overview");
            String releaseDate = result.getString("release_date");
            String image = result.getString("poster_path");
            Integer id = result.getInt("id");
            Optional<Movie> movieExists = movieRepository.findByapiMovieId(id);
            Movie a = movieExists.orElse(null);
            if (a == null) {
                movie = new Movie(title, description, releaseDate, image, id);
                movieRepository.save(movie);               
            }
        }
        return "movies saved";
    }
    
}