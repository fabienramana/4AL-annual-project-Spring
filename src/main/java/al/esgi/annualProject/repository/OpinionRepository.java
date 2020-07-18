package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
    List<Opinion> findByMovieId(Integer movieId);
    List<Opinion> findByUserId(String userId);
    Opinion findFirstByOrderByIdDesc();
}
