package al.esgi.annualProject.repository;

import al.esgi.annualProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    Optional<User> findByUserIdAndroid(String userIdAndroid);

}