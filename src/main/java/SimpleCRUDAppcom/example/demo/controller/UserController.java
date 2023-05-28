package SimpleCRUDAppcom.example.demo.controller;

import SimpleCRUDAppcom.example.demo.Response.ErrorMessage;
import SimpleCRUDAppcom.example.demo.model.User;
import SimpleCRUDAppcom.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getUser(@PathVariable("name") String name) {
        User user = userService.getUser(name);
        if (user == null) {
            ErrorMessage errorMessage = new ErrorMessage("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        if (createdUser == null) {
            ErrorMessage errorMessage = new ErrorMessage("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser == null) {
            ErrorMessage errorMessage = new ErrorMessage("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam("name") String name) {
        System.out.println(name);
        User deletedUser = userService.deleteUser(name);
        if (deletedUser == null) {
            ErrorMessage errorMessage = new ErrorMessage("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        return ResponseEntity.ok(deletedUser);
    }
}
