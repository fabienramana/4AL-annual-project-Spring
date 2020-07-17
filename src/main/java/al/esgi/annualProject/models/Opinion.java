package al.esgi.annualProject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="opinion")
public class Opinion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name="note")
    private Double note;

    @NotNull
    @Column(name="isLiked", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isLiked;

    @Lob
    @Column(name="comment", nullable = false, columnDefinition = "text", length=3000)
    private String comment;

    @NotNull
    @Column(name="user_id")
    private String userId;

    @NotNull
    @Column(name = "movie_id")
    private Integer movieId;
    
    public Opinion(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
    
    public boolean getIsLiked(){
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}
