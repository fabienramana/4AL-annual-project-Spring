package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
    List<Opinion> findByMovieId(Integer movieId);
    List<Opinion> findByUserId(String userId);
    Opinion findFirstByOrderByIdDesc();

    @Query("SELECT AVG(e.note) FROM Opinion e WHERE e.movieId = ?1")
    public Double findAverageNoteByMovie(Integer movieId);

    @Query("SELECT AVG(e.isLiked) FROM Opinion e WHERE e.movieId = ?1")
    public Double findAverageLikeNoteByMovie(Integer movieId);
}
