package thehv.test_redis;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRedisController {
    @Autowired
    UserRedisRepo userRedisRepo;

    @GetMapping("/testRedis")
    public Object testRedis() {
        userRedisRepo.save(new UserRedis(UUID.randomUUID().toString(), "Hoang", "The"));
        return userRedisRepo.findByFirstNameAndLastName("Hoang", "The");
    }
}