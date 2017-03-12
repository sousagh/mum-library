package edu.mum.library.data.impl;

import edu.mum.library.data.DataAccessObject;

public final class DataObjectFactory {
	private static DataAccessObject dao = new DataAccessObjectImpl();

	private DataObjectFactory() {
	}

	public static DataAccessObject getDataObject() {

		return dao;
	}
}
