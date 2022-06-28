package thehv.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // public User getUserLogin() {
    //     return userRepository.getById(id)
    //     return new User();
    // }
}