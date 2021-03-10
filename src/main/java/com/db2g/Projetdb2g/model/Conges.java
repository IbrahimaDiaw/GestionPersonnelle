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

@Document(collection="conges")
public class Conges {
	
	@Id
	private ObjectId id;
	@Indexed
	private String datebebut;
	@Indexed
	private String datefin;
	@Indexed
	private String nature;
	@Indexed
	private List<Employee> employee;
	
	/**
	 * @param datebebut
	 * @param datefin
	 * @param nature
	 * @param employee
	 */
	public Conges(String datebebut, String datefin, String nature, List<Employee> employee) {
		super();
		this.datebebut = datebebut;
		this.datefin = datefin;
		this.nature = nature;
		this.employee = employee;
	}
	/**
	 * 
	 */
	public Conges() {
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
	 * @return the datebebut
	 */
	public String getDatebebut() {
		return datebebut;
	}
	/**
	 * @param datebebut the datebebut to set
	 */
	public void setDatebebut(String datebebut) {
		this.datebebut = datebebut;
	}
	/**
	 * @return the datefin
	 */
	public String getDatefin() {
		return datefin;
	}
	/**
	 * @param datefin the datefin to set
	 */
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	/**
	 * @return the nature
	 */
	public String getNature() {
		return nature;
	}
	/**
	 * @param nature the nature to set
	 */
	public void setNature(String nature) {
		this.nature = nature;
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
