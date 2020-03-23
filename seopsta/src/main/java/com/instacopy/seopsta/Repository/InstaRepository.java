package com.instacopy.seopsta.Repository;

import com.instacopy.seopsta.Entity.InstaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface InstaRepository extends MongoRepository<InstaEntity,String> {
    int countByUseridEquals(String userid);
    InstaEntity findByUseridEquals(String userid);
    InstaEntity findByUsernickEquals(String usernick);
    InstaEntity findByUseridEqualsOrUsernickEquals(String id, String nick);
}
