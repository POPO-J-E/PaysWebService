package ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import persistance.DialogueBd;
import meserreurs.MonException;
import metier.Pays;

@WebService(serviceName = "PaysService")
public class PaysService implements PaysServiceInterface   {
	/* (non-Javadoc)
	 * @see ws.PaysServiceInterface#getUnPays(java.lang.String)
	 */
	@Override
	@WebMethod(operationName = "getUnPays")
	public  Pays getUnPays( @WebParam(name = "name")  String name) throws MonException
	{

		Pays pr;

		try
		{
			pr = getUnPaysPrive(name);

		} catch (MonException e)
		{
			//System.out.println(e.getMessage());
			throw e;
		}
		return pr;
	}



	/* (non-Javadoc)
	 * @see ws.PaysServiceInterface#getListeTousLesPays()
	 */
	@Override
	@WebMethod(operationName = "getListeTousLesPays")
	public List<Pays>   getListeTousLesPays() throws MonException
	{

		List<Pays> mesPays;


		try
		{
			mesPays = getListeTousLesPaysPrive();

		} catch (MonException e)
		{
			//System.out.println(e.getMessage());
			throw e;
		}
		return mesPays;
	}


	///
	/// Traitements priv�s
	///

	private List<Pays> getListeTousLesPaysPrive( ) throws MonException
	{

		List<Object> rs;
		List<Pays> mesPays = new ArrayList<Pays>();

		int index=0;


		try
		{
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			String mysql = "";
			mysql = "SELECT * FROM pays ORDER BY nom_pays ASC";
			rs= unDialogueBd.lecture(mysql); 
			while(index < rs.size())
			{ 
				// On cr�e un pays
				Pays unP;
				// il faut redecouper la liste pour retrouver les lignes
				unP = new Pays(rs.get(index+0).toString().toString(), rs.get(index+1).toString(), rs.get(index+2).toString(),Float.parseFloat(rs.get(index+3).toString()));
				// On incr�mente tous les 4 champs
				index= index+4;
				mesPays.add(unP);
			}
			return mesPays;

		} catch (MonException e)
		{
			//System.out.println(e.getMessage());
			throw e;
		}
	}




	private Pays  getUnPaysPrive( String nomp) throws MonException
	{
		List<Object> rs;	
		String mysql;
		try
		{
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			mysql = "SELECT * FROM pays where nom_pays = "  + "'" + nomp +"'";
			rs= unDialogueBd.lecture(mysql); 
			Pays unP = new Pays ();
			if (  rs.size()>0 )
			{ 

				// On r�cup�re les infos du pays 
				unP = new Pays(rs.get(0).toString().toString(), rs.get(1).toString(),rs.get(2).toString(), Float.parseFloat(rs.get(3).toString()));
			}
			return unP;	
		} catch (MonException e)
		{
			//System.out.println(e.getMessage());
			throw e;
		}
	}

}
