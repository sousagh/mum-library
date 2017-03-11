package edu.mum.library.business.bo.impl;

import edu.mum.library.business.User;
import edu.mum.library.business.bo.LoginBO;
import edu.mum.library.data.DataAccessObject;
import edu.mum.library.data.impl.DataAccessObjectImpl;
import edu.mum.library.data.impl.DataObjectFactory;

public class LoginBOImpl implements LoginBO {

	LoginBOImpl() {
	}

	@Override
	public User login(String username, String password) {

		DataAccessObject dao = (DataAccessObjectImpl) DataObjectFactory.getDataObject(DataAccessObject.class);

		User user = (User) dao.read(username, User.class);
		if (user != null && user.getPassword().equals(password)) {

			return user;
		}
		return null;
	}

}
