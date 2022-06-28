package thehv.users;

import javax.persistence.*;

import lombok.Data;
import java.io.Serializable;

@Entity
@Data
public class UserRole {

    @EmbeddedId
    private UserRoleKey userRoleKey;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    private Role role;

    @Embeddable
    class UserRoleKey implements Serializable {
        int userId;
        int roleId;
    }
}