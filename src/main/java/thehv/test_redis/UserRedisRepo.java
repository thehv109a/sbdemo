package thehv.test_redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRedisRepo extends CrudRepository<UserRedis, String> {
    Optional<List<UserRedis>> findByFirstNameAndLastName(String firstName, String lastName);
}