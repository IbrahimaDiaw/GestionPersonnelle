/**
 * 
 */
package com.db2g.Projetdb2g.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ibrahima
 *
 */
@Document(collection="absence")
public class Absence {
	
	@Id
	private ObjectId id;
	@Indexed
	private String dateabsence;
	@Indexed
	private String dureabsence;
	@Indexed
	private String motifabsence;
	@Indexed
	private List<Employee> employee;
	/**
	 * @param dateabsence
	 * @param dureabsence
	 * @param modtifabsence
	 * @param employee
	 */
	public Absence(String dateabsence, String dureabsence, String motifabsence, List<Employee> employee) {
		super();
		this.dateabsence = dateabsence;
		this.dureabsence = dureabsence;
		this.motifabsence = motifabsence;
		this.employee = employee;
	}
	/**
	 * 
	 */
	public Absence() {
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
	 * @return the dateabsence
	 */
	public String getDateabsence() {
		return dateabsence;
	}
	/**
	 * @param dateabsence the dateabsence to set
	 */
	public void setDateabsence(String dateabsence) {
		this.dateabsence = dateabsence;
	}
	/**
	 * @return the dureabsence
	 */
	public String getDureabsence() {
		return dureabsence;
	}
	/**
	 * @param dureabsence the dureabsence to set
	 */
	public void setDureabsence(String dureabsence) {
		this.dureabsence = dureabsence;
	}
	/**
	 * @return the motifabsence
	 */
	public String getMotifabsence() {
		return motifabsence;
	}
	/**
	 * @param modtifabsence the motifabsence to set
	 */
	public void setMotifabsence(String motifabsence) {
		this.motifabsence = motifabsence;
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
