package edu.mum.library.data.impl;

import java.util.HashMap;
import java.util.Map;

import edu.mum.library.data.MemberDataAccess;



public final class DataObjectFactory {
	private static Map<Class<?>, Object> dataObjects = new HashMap<>();

	static {
		dataObjects.put(MemberDataAccess.class, new MemberDataAccessImpl());
		
	}

	public static Object getBusinessObject(Class<?> class1) {

		return dataObjects.get(class1);
	}
}
