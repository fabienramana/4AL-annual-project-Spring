package al.esgi.annualProject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="commentaries")
public class Commentaries {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    @NotNull
    @Column(name = "movie_id")
    private Integer movieId;

    @NotNull
    @Column(name="comment")
    private String comment;
    
    public Commentaries(){
    }
    
    public Commentaries (String comment, Integer movieId, Integer userId){
        this.comment = comment;
        this.userId = userId;
        this.movieId = movieId;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
