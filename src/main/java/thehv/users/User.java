package thehv.users;

import javax.persistence.*;

import lombok.Data;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserRole> roles;
}