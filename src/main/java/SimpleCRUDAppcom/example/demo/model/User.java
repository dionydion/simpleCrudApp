package SimpleCRUDAppcom.example.demo.model;

import jakarta.persistence.*;

@Entity // allows the class to be stored in database
@Table(name="user_table") // names the table
public class User {
    @Id // this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generate a new id
    public Long id;

    @Column(unique = true) // the name column must be unique
    public String name;
    public int age;

}
