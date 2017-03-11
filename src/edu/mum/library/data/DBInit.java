package edu.mum.library.data;

import edu.mum.library.business.Role;
import edu.mum.library.business.User;
import edu.mum.library.data.impl.DataAccessObjectImpl;
import edu.mum.library.data.impl.DataObjectFactory;

public class DBInit {

	public static void populate() {
		DataAccessObject dao = (DataAccessObjectImpl) DataObjectFactory.getDataObject(DataAccessObject.class);

		String password = "123";
		User user = new User("lib", password, Role.LIBRARIAN);
		dao.save("lib", user);

		user = new User("admin", password, Role.ADMINISTRATOR);
		dao.save("admin", user);

		user = new User("super", password, Role.LIBRARIAN_ADMINISTRATOR);
		dao.save("super", user);
	}

}
