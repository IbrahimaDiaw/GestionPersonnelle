package com.db2g.Projetdb2g.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.db2g.Projetdb2g.model.Conges;

/**
 * @author ibrahima
 *
 */
@Repository
public interface CongesRepository extends MongoRepository<Conges, ObjectId> {

}
