package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByapiCategoryId(Integer apiCategoryId);
}
