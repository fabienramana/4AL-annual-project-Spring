package al.esgi.annualProject.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="likes")
public class Likes {
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
    @Column(name="like_status", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean likeStatus;
    
    public Likes(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public boolean getLikeStatus(){
        return likeStatus;
    }
    
    public void setLikeStatus(boolean likeStatus){
        this.likeStatus = likeStatus;
    }
}
