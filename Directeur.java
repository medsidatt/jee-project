package mr.iscae;

public class Directeur extends User {

	private Magasin magasin;
	public Directeur() {
		
	}
	
	public Directeur(int id, String userName, String password, String role) {
		super(id, userName, password, role);
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}
	
	
}
