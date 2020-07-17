package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Integer> {
}
