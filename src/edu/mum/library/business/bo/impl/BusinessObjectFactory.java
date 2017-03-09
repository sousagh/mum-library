package edu.mum.library.business.bo.impl;

import java.util.HashMap;
import java.util.Map;

import edu.mum.library.business.bo.BookBO;
import edu.mum.library.business.bo.LoginBO;
import edu.mum.library.business.bo.MemberBO;
import edu.mum.library.business.bo.PublicationBO;

public final class BusinessObjectFactory {

	private static Map<Class<?>, Object> businessObjects = new HashMap<>();

	static {
		businessObjects.put(LoginBO.class, new LoginBOImpl());
		businessObjects.put(MemberBO.class, new MemberBOImpl());
		businessObjects.put(BookBO.class, new BookBOImpl());
		businessObjects.put(PublicationBO.class, new PublicationBOImpl());
	}

	public static Object getBusinessObject(Class<?> class1) {

		return businessObjects.get(class1);
	}

}
