package SimpleCRUDAppcom.example.demo.service;

import SimpleCRUDAppcom.example.demo.model.User;
import SimpleCRUDAppcom.example.demo.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(String name) {
        Optional<User> optionalUser = userRepo.findByName(name);
        return optionalUser.orElse(null);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User updatedUser) {
        Optional<User> existingUser = userRepo.findByName(updatedUser.name);
        if (existingUser.isPresent()) {
            existingUser.get().age = updatedUser.age;
            return userRepo.save(existingUser.get());
        }
        return null;

    }

    @Transactional
    public User deleteUser(String name) {
        Optional<User> existingUser = userRepo.findByName(name);
        if (existingUser.isPresent()) {
            userRepo.deleteByName(name);
            return existingUser.get();
        }
        return null;
    }
}
