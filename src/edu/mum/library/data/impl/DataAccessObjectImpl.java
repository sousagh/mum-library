package edu.mum.library.data.impl;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.library.data.DataAccessObject;

public class DataAccessObjectImpl implements DataAccessObject {
	public static final String OUTPUT_DIR = ".." + File.separator + "data" + File.separator;
	public static final String DATE_PATTERN = "MM/dd/yyyy";


	DataAccessObjectImpl(){}

	@Override
	public void save(String id, Object object) {
		ObjectOutputStream out = null;

		ObjectMapper mapper = new ObjectMapper();
		try {
			File directory = new File(OUTPUT_DIR + object.getClass().getSimpleName());
			if (!directory.exists()) {

				directory.mkdirs();
			}
			File file = new File(OUTPUT_DIR + object.getClass().getSimpleName() + File.separator + id);
			if (!file.exists()) {
				file.createNewFile();
			}

			// out = new ObjectOutputStream(new FileOutputStream(file));
			// out.writeObject(object);
			mapper.writeValue(file, object);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}

	@Override
	public Object read(String id, Class<?> clazz) {
		Object member = null;
		try {
			File file = new File(OUTPUT_DIR + clazz.getSimpleName() + File.separator + id);

			ObjectMapper mapper = new ObjectMapper();
			member = mapper.readValue(file, clazz);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public List<Object> search(Map<String, String> params, Class<?> clazz) {

		List<Object> objects = new ArrayList<>();

		File file = new File(OUTPUT_DIR + clazz.getSimpleName());
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();

			for (File file2 : listFiles) {
				ObjectMapper mapper = new ObjectMapper();
				try {
					Map<String, Object> member = mapper.readValue(file, Map.class);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return objects;
	}

}
