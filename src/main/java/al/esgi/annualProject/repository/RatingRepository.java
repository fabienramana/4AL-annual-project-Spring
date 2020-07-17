package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
