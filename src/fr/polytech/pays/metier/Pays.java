package fr.polytech.pays.metier;

import java.io.Serializable;




public class Pays implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * nom du pays
	 */
	
	private String nomPays;

	
	private String nomCapitale;

	
	private String nomContinent;

	/**
	 * nombre d'habitants de la capitale
	 */

	private float nbhabitants;

	/**
	 * Create a country entity.
	 */
	public Pays() {
	}

	
		
	public String getNomPays() {
		return nomPays;
	}

	
	public void setNomPays(String name) {
		this.nomPays = name;
	}

	
	public String getNomCapitale() {
		return nomCapitale;
	}

	public void setNomCapitale(String capitale) {
		this.nomCapitale = capitale;
	}

	
	public String getNomContinent() {
		return nomContinent;
	}

	
	public void setNomContinent(String continent) {
		this.nomContinent = continent;
	}

	public float getNbhabitants() {
		return nbhabitants;
	}


	public void setNbhabitants(float nbhabitants) {
		this.nbhabitants = nbhabitants;
	}
	
	public Pays(String nom_pays, String nom_capitale,String nomContinent, float nbhabitants) {
		super();
		this.nomPays = nom_pays;
		this.nomCapitale = nom_capitale;
		this.nomContinent=nomContinent;
		this.nbhabitants = nbhabitants;
	}
}