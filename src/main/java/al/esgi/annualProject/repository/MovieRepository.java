package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
