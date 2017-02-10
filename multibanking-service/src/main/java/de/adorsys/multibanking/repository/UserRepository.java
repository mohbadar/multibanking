package de.adorsys.multibanking.repository;

import de.adorsys.multibanking.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Created by alexg on 07.02.17.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findById(String id);
}
