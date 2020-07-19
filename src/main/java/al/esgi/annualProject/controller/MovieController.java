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
    public String addNewMovie (@RequestBody Movie movie) {
        return movieService.addNewMovie(movie);
        
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    
    @GetMapping(path="/{id}")
    public Optional<Movie> getMovieById(@PathVariable int id){
        return movieService.getMovieById(id);
    }

    @PutMapping(path="/{id}")
    public String modifyMovieAverageCommentNoteById(@PathVariable int id, @RequestBody Movie movie){
        return movieService.modifyMovieAverageCommentNoteById(id, movie);
    }
    
    @GetMapping(path="/get-api")
    public String getMoviesFromApi() throws IOException, InterruptedException {
        return movieService.getMoviesFromApi();
       /* URL url = new URL("https://api.themoviedb.org/3/movie/now_playing?api_key="+ apiKey);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        String response = content.toString();
        
        JSONObject json = new JSONObject(response);
        JSONArray results = json.getJSONArray("results");
        StringBuilder str = new StringBuilder();
        Movie movie;
        for (Object o : results) {
            StringBuilder categoriesBuilder = new StringBuilder();
            JSONObject result = (JSONObject) o;
            String title = result.getString("title");
            String description = result.getString("overview");
            String releaseDate = result.getString("release_date");
            String image = result.getString("poster_path");
            Integer id = result.getInt("id");
            Integer popularity = result.getInt("popularity");
            JSONArray categories = result.optJSONArray("genre_ids");
            int[] numbers = new int[categories.length()];
            for (int i = 0; i < categories.length(); ++i) {
                numbers[i] = categories.optInt(i);
                Optional<Category> categoryExists = categoryRepository.findByapiCategoryId(numbers[i]);
                if(i == categories.length()-1){
                    categoriesBuilder.append(categoryExists.get().getLabel());
                }
                else{
                    categoriesBuilder.append(categoryExists.get().getLabel() + ", ");
                }
            }
            Optional<Movie> movieExists = movieRepository.findByapiMovieId(id);
            Movie a = movieExists.orElse(null);
            if (a == null) {
                movie = new Movie(title, description, releaseDate, image, id, popularity, categoriesBuilder.toString());
                movieRepository.save(movie);               
            }
        }
        return "movies saved";*/
    }
    
}
