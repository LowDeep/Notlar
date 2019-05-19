package code;

public class note {
	int idUser;
	int idNote;
	String descriptionNote;
	int validationNote;
	
	//constructeur
	public note(int idUser,int idNote,String note)
	{
		this.idUser=idUser;
		this.idNote=idNote;
		this.descriptionNote = note;
		this.validationNote=0;
	}
	//		GETTERS - SETTERS

	public int getIdUser() {
		return idUser;
	}

	public String getDescriptionNote() {
		return descriptionNote;
	}

	public void setDescriptionNote(String descriptionNote) {
		this.descriptionNote = descriptionNote;
	}

	public int isValidationNote() {
		return validationNote;
	}

	public void setValidationNote(int validationNote) {
		this.validationNote = validationNote;
	}

	public int getIdNote() {
		return idNote;
	}
	
	
	 
	
	

}
