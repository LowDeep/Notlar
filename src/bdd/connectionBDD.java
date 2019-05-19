package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import code.note;
import code.rappel;
import code.user;
import code.users;
import imports.LList;

public class connectionBDD {
	
	private String url="jdbc:mysql://localhost:3306/Notlar";
    private String username = "root";
    private String password = "";
    private Connection connection;
	private Statement st = null;
	
	public connectionBDD() {
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
				connection= DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				//System.err.println("erreur de chargement du driver");
				e.printStackTrace();
			}
	 catch (SQLException e) {
		System.err.println("erreur de chargement du driver");
		e.printStackTrace();
	}
	}
	
	
	 /*
    Users findAllUsers() permettant de retourner tous les utilisateurs dans la bdd
    */
    public users findAllUsers(){
    	users listeUsers = new users();
        ResultSet res = null;
        String requette = "SELECT * FROM utilisateur";
        try {
            Statement statement = connection.createStatement();
            res = statement.executeQuery(requette);
            
            while(res.next()){
               user p = new user(res.getInt("id_user"),res.getString("name_user"),res.getString("email"));
                listeUsers.add(p);
            }
            
        } catch (SQLException ex) {
        	System.err.println("erreur d'execution de la requette");
    		ex.printStackTrace();
                  }
        
        return listeUsers;
    }

    /*
     * Methode pour ajouter un utilisateur a la base de donnée 
     */
	public boolean addUser(user usr)
	{
		boolean flag = false;
		int res;
		String requette = "INSERT INTO utilisateur(name_user,email) VALUES ('"+(String)usr.getName()+"','"+(String)usr.getEmail()+"');";
		try {
			Statement statement = connection.createStatement();
            res = statement.executeUpdate(requette);
            if(res==1){
            	System.out.println("utilisateur bien inséré");
                flag= true;
            	}else {
            		System.out.println("erreur insertion utilisateur");
            	}
         	}catch (SQLException ex) {
         		System.err.println("erreur d'execution de la requette");
        		ex.printStackTrace();
            }
    
		return flag;
	}
	

	/*
	 * Methode pour afficher les notes de la bdd
	 */
	public LList<note> findAllNotes(){
    	LList<note> listeNotes = new LList<note>();
        ResultSet res = null;
        String requette = "SELECT * FROM notes";
        try {
            Statement statement = connection.createStatement();
            res = statement.executeQuery(requette);
            
            while(res.next()){
               note p = new note(res.getInt("id_user"),res.getInt("id_note"),res.getString("description"));
                listeNotes.add(p);
            }
            
        } catch (SQLException ex) {
        	System.err.println("erreur d'execution de la requette");
    		ex.printStackTrace();
                  }
        
        return listeNotes;
    }
	/*
	 * Methode pour afficher kes rappels de la bdd
	 */
	public LList<rappel> findAllRappel(){
    	LList<rappel> listeRappels = new LList<rappel>();
        ResultSet res = null;
        String requette = "SELECT * FROM rappels";
        try {
            Statement statement = connection.createStatement();
            res = statement.executeQuery(requette);
            
            while(res.next()){
               rappel p = new rappel(res.getInt("id_rappel"),res.getString("date_rappel"));
               listeRappels.add(p);
            }
            
        } catch (SQLException ex) {
        	System.err.println("erreur d'execution de la requette");
    		ex.printStackTrace();
                  }
        
        return listeRappels;
    }
	
	/*
	 * Methode pour ajouter une note a la base de donnée
	 */
	public boolean addNote(note nt)
	{
		boolean flag = false;
		int res;
		String requette = "INSERT INTO notes(id_user,description,validation) VALUES ('"+nt.getIdUser()+"','"+nt.getDescriptionNote()+"','"+nt.isValidationNote()+"');";
		try {
			Statement statement = connection.createStatement();
            res = statement.executeUpdate(requette);
            if(res==1){
            	System.out.println("note bien inséré");
                flag= true;
            	}else {
            		System.out.println("erreur insertion note");
            	}
         	}catch (SQLException ex) {
         		System.err.println("erreur d'execution de la requette");
        		ex.printStackTrace();
            }
    
		return flag;
	}
	/*
	 * Methode pour ajouter une note a la base de donnée CELON L'UTILISATEUR
	 */
	/* METHODE NE SERT PLUS A RIEN TOPOLOGIE DE LA BDD A CHANGEE, 
	public boolean addNoteByUser(note nt,user usr)
	{
		boolean flag = false;
		int res,res2;
		String requette = "INSERT INTO notes(description,validation) VALUES ('"+nt.getDescriptionNote()+"','"+nt.isValidationNote()+"');";
		
		String requette2 =  "INSERT INTO user_note(id_user,id_note) VALUES ("+usr.getId()+","+nt.getIdNote()+");";
		try {
			Statement statement = connection.createStatement();
            res = statement.executeUpdate(requette);
            res2 = statement.executeUpdate(requette2);
            if(res==1 && res2 ==1){
            	System.out.println("note_user bien inséré");
                flag= true;
            	}else {
            		System.out.println("erreur insertion note_usr");
            	}
         	}catch (SQLException ex) {
         		System.err.println("erreur d'execution de la requette");
        		ex.printStackTrace();
            }
    
		return flag;
	}
	*/

	
	
}
