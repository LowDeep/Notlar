package code;

import bdd.connectionBDD;

public class mainNotlar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*user user1 = new user (1,"taha", "taha2");
		user user2 = new user (2,"taha", "taha2");
		user user3 = new user (3,"taha", "taha2");
		System.out.println(user1.toString());
		users listeuser = new users();
		listeuser.add(user1);
		listeuser.add(user2);
		listeuser.add(user3);

		listeuser.add(user3);*/
		//System.out.println(listeuser.toString());
		//System.out.println(listeuser.getListeUtilisateurs().toString());
	//	user user1 = new user (1,"nomuser", "@mail");
	
		connectionBDD testConnection = new connectionBDD();
		//System.out.println(testConnection.findAllUsers());
		//testConnection.addUser(user1);
	}

}
