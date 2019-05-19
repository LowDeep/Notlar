package code;

public class rappel {
	private int id_rappel;
	private String date_rappel;
	
	//CONSTRUCTEUR
	public rappel(int id_rappel,String date_rappel)
	{
		this.id_rappel = id_rappel;
		this.date_rappel = date_rappel;
	}
	// GETTERS  --- SETTERS
	public String getDate_rappel() {
		return date_rappel;
	}

	public void setDate_rappel(String date_rappel) {
		this.date_rappel = date_rappel;
	}

	public int getId_rappel() {
		return id_rappel;
	}
	
	
	
	
	
}
