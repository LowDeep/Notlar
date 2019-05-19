package code;

import imports.Tuple;

public class user {
	
	private int id;
	private String name;
	private String email;
	
	//constructeur avec elements utilisateur
	public user(int id,String name, String email)
	{
		this.id=id;
		this.name=name;
		this.email=email;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "idUser: "+id+" \t nameUser: "+name+" \temailUser: "+email+"\n";
	}

	
	
	
	
	

}
