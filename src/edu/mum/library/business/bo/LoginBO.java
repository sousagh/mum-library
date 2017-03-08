package edu.mum.library.business.bo;

import edu.mum.library.business.User;

public interface LoginBO {
	User login(String username, String password);
}
