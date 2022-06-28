package thehv.test_mongo;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepo extends MongoRepository<UserMongo, Integer> {
}
