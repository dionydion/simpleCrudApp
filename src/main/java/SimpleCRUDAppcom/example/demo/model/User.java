package SimpleCRUDAppcom.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public String name;
    public int age;

}
