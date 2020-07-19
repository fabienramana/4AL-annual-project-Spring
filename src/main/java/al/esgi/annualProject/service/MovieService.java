package al.esgi.annualProject.service;

import al.esgi.annualProject.models.Category;
import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.repository.CategoryRepository;
import al.esgi.annualProject.repository.MovieRepository;
import al.esgi.annualProject.utils.DoRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public String apiKey = "e80ae4cad06b931beaa5b7f21ea45904";
    
    public Movie addNewMovie(Movie movie){
        return movieRepository.save(movie);
    }
    
    public Iterable<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    
    public Optional<Movie> getMovieById(int id){
        Optional<Movie> movie = movieRepository.findById(id);
        return movie;
    }
    
    public Movie modifyMovieAverageCommentNoteById(int id, Movie movie){
        Movie movieFound = movieRepository.getOne(id);
        movieFound.setAverageCommentNote(movie.getAverageCommentNote());
        return movieRepository.save(movieFound);
    }
    
    public String getMoviesFromApi() throws IOException, InterruptedException {
        DoRequest request = new DoRequest("https://api.themoviedb.org/3/movie/now_playing?api_key="+ apiKey + "&language=fr-FR");
        String response = request.getRequest();

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
        return "movies saved";
    }
}
