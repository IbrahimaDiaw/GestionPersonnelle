package com.db2g.Projetdb2g.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.db2g.Projetdb2g.model.Formation;

public interface FormationRepository extends MongoRepository<Formation, ObjectId>{

}
