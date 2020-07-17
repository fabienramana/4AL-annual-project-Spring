package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    public Optional<Movie> findByapiMovieId(Integer id);
}
