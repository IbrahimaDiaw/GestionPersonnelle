/**
 * 
 */
package com.db2g.Projetdb2g.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author ibrahima
 *
 */

@Document(collection="employee")
public class Employee {
	
	@Id
	private ObjectId id;
	
	@Indexed(unique = false)
    @Field(value = "nom")
	private String nom;
	
	@Indexed(unique = false)
    @Field(value = "prenom")
	private String prenom;
	
	@Indexed(unique = false)
    @Field(value = "email")
	private String email;
	
	@Indexed(unique = false)
    @Field(value = "adresse")
	private String adresse;
	
	@Indexed(unique = false)
    @Field(value = "fonction")
	private String fonction ;
	
	@Indexed(unique = false)
    @Field(value = "tel")
	private int tel;
	
	@Indexed(unique = false)
    @Field(value = "salaire")
	private float salaire;
	
	/**
	 * 
	 */
	public Employee() {
		super();
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 * @param fonction
	 * @param tel
	 * @param salaire
	 */
	public Employee(String nom, String prenom, String email, String adresse, String fonction, int tel, float salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.fonction = fonction;
		this.tel = tel;
		this.salaire = salaire;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the fonction
	 */
	public String getFonction() {
		return fonction;
	}
	/**
	 * @param fonction the fonction to set
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	/**
	 * @return the tel
	 */
	public int getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(int tel) {
		this.tel = tel;
	}
	/**
	 * @return the salaire
	 */
	public float getSalaire() {
		return salaire;
	}
	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	
}
