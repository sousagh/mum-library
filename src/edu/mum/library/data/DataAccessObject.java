package edu.mum.library.data;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.library.business.Book;

public interface DataAccessObject {

	void save(String id, Object object);

	Object read(String id, Class<?> clazz);

	Set<Object> search(Map<String, String> params, Class<?> clazz);

	List<Object> findAll(Class<Book> class1);

}
