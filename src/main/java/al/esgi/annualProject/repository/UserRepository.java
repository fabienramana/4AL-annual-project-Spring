package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    Optional<User> findByUserIdAndroid(String userIdAndroid);

}