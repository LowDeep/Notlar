package code;

import imports.LList;
import imports.Node;

public class users extends LList<user> {
	
	LList<user> listeUtilisateurs;
	

	
	//constructeur liste utilisateurs
	public users()
	{
		listeUtilisateurs = new LList<user>();
	}
	//GETTER LISTE UTILISATEUR
	public LList<user> getListeUtilisateurs() {
		return listeUtilisateurs;
	}
	/*
	 * Methode pour ajouter utilisateur dans la liste users
	 * si id utilisateur existe, pas besoin de l'ajouter
	 */
	public void add(user elem)
	{
		if(!listeUtilisateurs.contains(elem))
			listeUtilisateurs.add(elem);
		else
			System.out.println("Utilisateur : "+elem.getName()+" déjà existant!");
	}
	/*
	 * TO string liste utilisateur
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return listeUtilisateurs.toString();
	}
	


	
	
	

}
