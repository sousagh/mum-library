package edu.mum.library.data.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.library.data.DataAccessObject;

public class DataAccessObjectImpl implements DataAccessObject {
	public static final String OUTPUT_DIR = "." + File.separator + "data" + File.separator;
	private static final String JSON = ".json";


	DataAccessObjectImpl(){}

	@Override
	public void save(String id, Object object) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			File directory = new File(OUTPUT_DIR + object.getClass().getSimpleName());
			if (!directory.exists()) {

				directory.mkdirs();
			}
			File file = new File(OUTPUT_DIR + object.getClass().getSimpleName() + File.separator + id + JSON);
			if (!file.exists()) {
				file.createNewFile();
			}
			mapper.writerWithDefaultPrettyPrinter().writeValue(file, object);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object read(String id, Class<?> clazz) {
		Object member = null;
		File file = new File(OUTPUT_DIR + clazz.getSimpleName() + File.separator + id + JSON);

		if (!file.exists()) {
			return null;
		}
		try {

			ObjectMapper mapper = new ObjectMapper();
			member = mapper.readValue(file, clazz);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public Set<Object> search(Map<String, String> params, Class<?> clazz) {

		Set<Object> objects = new HashSet<>();

		File directory = new File(OUTPUT_DIR + clazz.getSimpleName());
		if (directory.isDirectory()) {
			File[] listFiles = directory.listFiles();

			for (File file : listFiles) {
				if(file.getName().endsWith(JSON)){
					ObjectMapper mapper = new ObjectMapper();
					try {
						JsonNode member = mapper.readValue(file, JsonNode.class);

						for (Entry<String, String> entry : params.entrySet()) {
							String searchParamValue = entry.getValue();
							if (!searchParamValue.isEmpty()) {
								Object objectValue = member.get(entry.getKey());

								if (objectValue != null && objectValue.toString().toLowerCase()
										.contains(searchParamValue.toLowerCase())) {

									objects.add(mapper.readValue(file, clazz));
								}
							}
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return objects;
	}

	@Override
	public List<Object> findAll(Class<?> clazz) {
		List<Object> objects = new ArrayList<>();
		File file = new File(OUTPUT_DIR + clazz.getSimpleName());
		ObjectMapper mapper = new ObjectMapper();
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				if (file2.getName().endsWith(JSON)) {

					try {
						objects.add(mapper.readValue(file2, clazz));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return objects;
	}

}
