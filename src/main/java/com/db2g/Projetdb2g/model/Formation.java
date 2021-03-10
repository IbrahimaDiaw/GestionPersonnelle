package com.db2g.Projetdb2g.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="formation")
public class Formation {

	@Id
	private ObjectId id;
	@Indexed
	private String libelle;
	@Indexed
	private int duree;
	@Indexed
	private String dateFormation;
	@Indexed
	private List<Employee> employee;
	/**
	 * @param libelle
	 * @param duree
	 * @param dateFormation
	 * @param employee
	 */
	public Formation(String libelle, int duree, String dateFormation, List<Employee> employee) {
		super();
		this.libelle = libelle;
		this.duree = duree;
		this.dateFormation = dateFormation;
		this.employee = employee;
	}
	/**
	 * 
	 */
	public Formation() {
		super();
	}
	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}
	/**
	 * @return the dateFormation
	 */
	public String getDateFormation() {
		return dateFormation;
	}
	/**
	 * @param dateFormation the dateFormation to set
	 */
	public void setDateFormation(String dateFormation) {
		this.dateFormation = dateFormation;
	}
	/**
	 * @return the employee
	 */
	public List<Employee> getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	
}
