package edu.mum.library.business;

public class User {
    private Role role;
	private String username;
	private String password;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
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
		return username;
	}
	
	public User(String user,String password,Role role){
		this.username=user;
		this.password=password;
		this.role=role;
	}
}
