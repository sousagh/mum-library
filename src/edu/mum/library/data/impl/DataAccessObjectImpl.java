package edu.mum.library.data.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.library.data.DataAccessObject;

public class DataAccessObjectImpl implements DataAccessObject {
	public static final String OUTPUT_DIR = ".." + File.separator + "data" + File.separator;
	public static final String DATE_PATTERN = "MM/dd/yyyy";
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

			// out = new ObjectOutputStream(new FileOutputStream(file));
			// out.writeObject(object);
			mapper.writeValue(file, object);
		} catch(IOException e) {
			e.printStackTrace();
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

	@Override
	public Set<Object> search(Map<String, String> params, Class<?> clazz) {

		Set<Object> objects = new HashSet<>();

		File file = new File(OUTPUT_DIR + clazz.getSimpleName());
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();

			for (File file2 : listFiles) {
				if(file2.getName().endsWith(JSON)){
					ObjectMapper mapper = new ObjectMapper();
					try {
						JsonNode member = mapper.readValue(file2, JsonNode.class);

						for (Entry<String, String> entry : params.entrySet()) {
							String searchParamValue = entry.getValue();
							if (!searchParamValue.isEmpty()) {
								Object objectValue = member.get(entry.getKey());
								if (objectValue != null && objectValue.toString().contains(searchParamValue)) {

									objects.add(mapper.readValue(file2, clazz));
								}
							}
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		return objects;
	}

}
