/**
 * 
 */
package com.db2g.Projetdb2g.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 * @author ibrahima
 *
 */
@Entity
@Table(name="offre")
public class Offre {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String intitule;
	@Column
	private String typeoffre;
	@Column
	@Type(type="text")
	private String description;
	/**
	 * @param intitule
	 * @param typeoffre
	 * @param description
	 */
	public Offre(String intitule, String typeoffre, String description) {
		super();
		this.intitule = intitule;
		this.typeoffre = typeoffre;
		this.description = description;
	}
	
	/**
	 * 
	 */
	public Offre() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}
	/**
	 * @param intitule the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	/**
	 * @return the typeoffre
	 */
	public String getTypeoffre() {
		return typeoffre;
	}
	/**
	 * @param typeoffre the typeoffre to set
	 */
	public void setTypeoffre(String typeoffre) {
		this.typeoffre = typeoffre;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
