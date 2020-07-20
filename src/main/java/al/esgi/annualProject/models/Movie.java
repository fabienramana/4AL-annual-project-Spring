package al.esgi.annualProject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description", nullable = false, columnDefinition = "text", length=3000)
    private String description;
    
    @NotNull
    @Column(name="releaseDate", nullable = false)
    private String releaseDate;
    
    @NotNull
    @Column(name="api_movie_id")
    private Integer apiMovieId;
    
    @NotNull
    @Column(name="image_url")
    private String image;

    @NotNull
    @Column(name="popularity")
    private Integer popularity;
    
    @NotNull
    @Column(name="categories", nullable = false)
    private String categories;
    
    @NotNull
    @Column(name="average_note")
    private Double averageNote;
    
    @NotNull
    @Column(name="average_likes")
    private Double averageLikes;
    
    @Column(name="average_comment_note")
    private Double averageCommentNote;
    
    public Movie(){        
    }
    
    public Movie(String title, String description, String releaseDate, String image, Integer id, Integer popularity, String categories){
        this.name = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.image = image;
        this.apiMovieId = id;
        this.popularity = popularity;
        this.categories = categories;
        this.averageLikes = 0.0;
        this.averageNote = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getApiMovieId() {
        return apiMovieId;
    }

    public void setApiMovieId(Integer apiMovieId) {
        this.apiMovieId = apiMovieId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Double getAverageNote() {
        return averageNote;
    }

    public void setAverageNote(Double averageNote) {
        this.averageNote = averageNote;
    }

    public Double getAverageCommentNote() {
        return averageCommentNote;
    }

    public void setAverageCommentNote(Double averageCommentNote) {
        this.averageCommentNote = averageCommentNote;
    }

    public Double getAverageLikes() {
        return averageLikes;
    }

    public void setAverageLikes(Double averageLikes) {
        this.averageLikes = averageLikes;
    }
}
