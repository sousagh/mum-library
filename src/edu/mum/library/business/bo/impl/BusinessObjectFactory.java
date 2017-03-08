package edu.mum.library.business.bo.impl;

import java.util.HashMap;
import java.util.Map;

import edu.mum.library.business.bo.LoginBO;

public final class BusinessObjectFactory {

	private static Map<Class<?>, Object> businessObjects = new HashMap<>();

	static {
		businessObjects.put(LoginBO.class, new LoginBOImpl());
	}

	public static Object getBusinessObject(Class<?> class1) {

		return businessObjects.get(class1);
	}

}
