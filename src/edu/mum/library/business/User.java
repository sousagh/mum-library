package edu.mum.library.business;

public class User {
	private IRole role;
	private String username;
	private String password;
	
	
	public IRole getRole() {
		return role;
	}

	public void setRole(IRole role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString(){
		return username+", "+role.getRoleName();
	}
}
