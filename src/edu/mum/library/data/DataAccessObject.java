package edu.mum.library.data;

public interface DataAccessObject {

	void save(String id, Object object);

	Object read(String id, Class<?> clazz);

}
