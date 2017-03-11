package edu.mum.library.business;

public class User {
	private Role role;
	private String username;
	private transient String password;

	public User(String user, String password, Role role) {
		this.username = user;
		this.password = password;
		this.role = role;
	}

	public User() {

	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString(){
		return this.username;
	}
}
