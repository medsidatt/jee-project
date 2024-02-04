package mr.iscae;

public class Directeur extends User {

	public Directeur() {
		
	}
	
	public Directeur(int id, String userName, String password, String role,  Magasin magasin) {
		super(id, userName, password, role, magasin);
	}

	
}
