/**
 * 
 */
package com.db2g.Projetdb2g.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db2g.Projetdb2g.model.Employee;

/**
 * @author ibrahima
 *
 */

@Repository
@Transactional
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
	
}
