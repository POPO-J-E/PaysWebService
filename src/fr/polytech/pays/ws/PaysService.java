package fr.polytech.pays.ws;

import java.util.ArrayList;
import java.util.List;

import fr.polytech.pays.metier.Pays;
import fr.polytech.pays.persistance.*;


public class PaysService {
	
	
	public PaysService() {
		
	}
	
	public Pays getUnPays(String nomp) throws Exception {
		Pays unP = null;
		List<Object> rs;	
		String mysql;
		try
		{
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			mysql = "SELECT * FROM pays where nom_pays = "  + "'" + nomp +"'";
			rs= unDialogueBd.lecture(mysql); 
			
			if (  rs.size()>0 )
			{ 
				// On récupère les infos du pays 
				unP = new Pays(rs.get(0).toString().toString(), rs.get(1).toString(),rs.get(2).toString(), Float.parseFloat(rs.get(3).toString()));
			}
			
			return unP;	
			
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		
	}
	
	public List<Pays> getListeTousLesPays() throws Exception {
		List<Pays> mesPays = new ArrayList<Pays>();
		try {
			
		
			List<Object> rs;
			
			// On crée un pays
			Pays unP;
			int index=0;
			
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			String mysql = "";
			mysql = "SELECT * FROM pays ORDER BY nom_pays ASC";
			rs= unDialogueBd.lecture(mysql); 
			
			while(index < rs.size())
			{ 
				// il faut redécouper la liste pour retrouver les lignes
				unP = new Pays(rs.get(index+0).toString().toString(), rs.get(index+1).toString(),rs.get(index+2).toString(),Float.parseFloat(rs.get(index+3).toString()));
				// On incrémente tous les 4 champs
				index= index+4;
				mesPays.add(unP);
			}
			
			return mesPays;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		
	}
	
	
}