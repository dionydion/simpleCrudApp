package SimpleCRUDAppcom.example.demo.repository;

import SimpleCRUDAppcom.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // changes this class to a repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
    void deleteByName(String name);
}
