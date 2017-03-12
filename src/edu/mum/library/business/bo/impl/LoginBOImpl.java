package edu.mum.library.business.bo.impl;

import edu.mum.library.business.User;
import edu.mum.library.business.bo.LoginBO;
import edu.mum.library.data.DataAccessObject;
import edu.mum.library.data.impl.DataObjectFactory;
import edu.mum.library.ui.util.AppContext;

public class LoginBOImpl implements LoginBO {

	LoginBOImpl() {
	}

	@Override
	public User login(String username, String password) {

		DataAccessObject dao = DataObjectFactory.getDataObject();

		User user = (User) dao.read(username, User.class);
		if (user != null && user.getPassword().equals(password)) {
			AppContext.putParam(AppContext.USER, user);
			return user;
		}
		return null;
	}

}
