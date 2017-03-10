package edu.mum.library.data.impl;

import java.util.HashMap;
import java.util.Map;

import edu.mum.library.data.DataAccessObject;



public final class DataObjectFactory {
	private static Map<Class<?>, Object> dataObjects = new HashMap<>();

	static {
		dataObjects.put(DataAccessObject.class, new DataAccessObjectImpl());

	}

	public static Object getDataObject(Class<?> class1) {

		return dataObjects.get(class1);
	}
}
