package com.db2g.Projetdb2g.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.db2g.Projetdb2g.model.Absence;

/**
 * @author ibrahima
 *
 */
@Repository
public interface AbsenceRepository extends MongoRepository<Absence, ObjectId> {

}
