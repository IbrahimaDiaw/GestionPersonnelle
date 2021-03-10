/**
 * 
 */
package com.db2g.Projetdb2g.Service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db2g.Projetdb2g.Repository.EmployeeRepository;
import com.db2g.Projetdb2g.Service.EmployeeService;
import com.db2g.Projetdb2g.model.Employee;

/**
 * @author ibrahima
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> listeEmployes() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> detailEmploye(ObjectId id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public void sauvegardeEmployee(Employee employe) {
		// TODO Auto-generated method stub
		employeeRepository.save(employe);
		
	}

	@Override
	public void supprimerEmployee(ObjectId id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee get(ObjectId id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

}
