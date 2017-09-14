package metier;

import java.io.Serializable;

public class Pays implements Serializable   {

	private static final long serialVersionUID = 9179597556705829498L;
	
	private String nomPays;
	private String nomCapitale;
	private String nomContinent;
	

	private float nbhabitants;
	

	public String getNomPays() {
		return nomPays;
	}


	
	public String getNomCapitale() {
		return nomCapitale;
	}


	
	public float getNbhabitants() {
		return nbhabitants;
	}

	public String getNomContinent() {
		return nomContinent;
	}


	public void setNomContinent(String nomContinent) {
		this.nomContinent = nomContinent;
	}

	public Pays(String nom_pays, String nom_capitale,String nomContinent, float nbhabitants) {
		super();
		this.nomPays = nom_pays;
		this.nomCapitale = nom_capitale;
		this.nomContinent=nomContinent;
		this.nbhabitants = nbhabitants;
	}

	public Pays() {
		super();
		
	}

	
}
