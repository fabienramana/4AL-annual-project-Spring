package al.esgi.annualProject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="commentaries")
public class Commentaries {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    public Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    
    
}
