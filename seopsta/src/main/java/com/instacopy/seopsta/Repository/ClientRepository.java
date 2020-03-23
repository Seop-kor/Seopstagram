package com.instacopy.seopsta.Repository;

import com.instacopy.seopsta.Entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {
}
