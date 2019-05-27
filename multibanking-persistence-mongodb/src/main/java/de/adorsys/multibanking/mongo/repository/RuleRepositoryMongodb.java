package de.adorsys.multibanking.mongo.repository;

import de.adorsys.multibanking.mongo.entity.RuleMongoEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"mongo", "fongo"})
public interface RuleRepositoryMongodb extends MongoRepository<RuleMongoEntity, String> {

    Page<RuleMongoEntity> findAll(Pageable pageable);

}