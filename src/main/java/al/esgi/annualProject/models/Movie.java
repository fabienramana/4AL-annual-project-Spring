package al.esgi.annualProject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    public Integer id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
}
