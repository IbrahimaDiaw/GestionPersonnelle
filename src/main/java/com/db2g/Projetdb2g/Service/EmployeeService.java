/**
 * 
 */
package com.db2g.Projetdb2g.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.db2g.Projetdb2g.model.Employee;

/**
 * @author ibrahima
 *
 */
public interface EmployeeService {
	
	public List<Employee> listeEmployes();
	public Optional<Employee> detailEmploye(ObjectId id);
	public void sauvegardeEmployee(Employee employe);
	public void supprimerEmployee(ObjectId id);
	public Employee get(ObjectId id);

}
