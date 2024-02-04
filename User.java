package mr.iscae;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty
	private int id;
	@JsonProperty
	private String userName;
	@JsonProperty
	private String password;
	@JsonProperty
	private String role;
	@JsonProperty
	private Magasin magasin;
	
	public User(int id, String userName, String password, String role) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	

	public User(int id, String userName, String password, String role, Magasin magasin) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.magasin = magasin;
	}



	public User() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public Magasin getMagasin() {
		return magasin;
	}


	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	
	
	
	
	
}
