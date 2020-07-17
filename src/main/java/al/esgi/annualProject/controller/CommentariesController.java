package al.esgi.annualProject.controller;

import al.esgi.annualProject.models.Commentaries;
import al.esgi.annualProject.models.Movie;
import al.esgi.annualProject.models.User;
import al.esgi.annualProject.repository.CommentariesRepository;
import al.esgi.annualProject.repository.MovieRepository;
import al.esgi.annualProject.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.Optional;

@RestController
@RequestMapping(path="/commentaries")
public class CommentariesController {
    @Autowired
    private CommentariesRepository commentariesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST) // Map ONLY POST Requests
    public String addNewComment (@RequestBody Commentaries comment) {
        Optional<Movie> movie = movieRepository.findById(comment.getMovieId());
        Optional<User> user = userRepository.findById(comment.getUserId());
        Commentaries newComment = new Commentaries(comment.getComment(), movie.get().getId(), user.get().getId());
        commentariesRepository.save(comment);
        return "Saved";
    }
    
    @GetMapping(path="/{id}")
    public Commentaries getCommentById(@PathVariable int id){
        Commentaries comment = commentariesRepository.getOne(id);
        return comment;
    }
    
    @DeleteMapping(path="{id}")
    public String deleteCommentById(@PathVariable int id){
        Commentaries comment = commentariesRepository.getOne(id);
        commentariesRepository.delete(comment);
        return "deleted";
    }
    
    @PutMapping(path="{id}")
    public String modifyCommentById(@PathVariable int id, @RequestBody Commentaries comment){
        Commentaries commentFound = commentariesRepository.getOne(id);
        commentFound.setComment(comment.getComment());
        commentariesRepository.save(commentFound);
        return "modified";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Commentaries> getAllCommentaries() {
        // This returns a JSON or XML with the users
        return commentariesRepository.findAll();
    }
}
