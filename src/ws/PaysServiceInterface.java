package ws;

import java.util.List;

import meserreurs.MonException;
import metier.Pays;

public interface PaysServiceInterface {

	Pays getUnPays(String nomp) throws MonException;

	List<Pays> getListeTousLesPays() throws MonException;

}