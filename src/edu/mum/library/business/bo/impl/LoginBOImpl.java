package edu.mum.library.business.bo.impl;

import edu.mum.library.business.User;
import edu.mum.library.business.bo.LoginBO;

public class LoginBOImpl implements LoginBO {

	LoginBOImpl() {
	}

	@Override
	public User login(String username, String password) {
		if (username.equals("user") && password.equals("123")) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);

			return user;
		}
		return null;
	}

}
