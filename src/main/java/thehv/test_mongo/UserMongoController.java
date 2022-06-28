package thehv.test_mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMongoController {
    @Autowired
    UserMongoRepo userMongoRepo;

    @GetMapping("/testMongo")
    public Object testMongo() {
        userMongoRepo.save(new UserMongo(1, "Peter", "Development", 3000L));
        userMongoRepo.save(new UserMongo(2, "Sam", "Operations", 2000L));
        return userMongoRepo.findAll();
    }
}