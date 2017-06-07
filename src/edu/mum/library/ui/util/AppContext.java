package edu.mum.library.ui.util;

import java.util.HashMap;
import java.util.Map;

public final class AppContext {

	private AppContext() {
	}

	private final static Map<String, Object> context = new HashMap<>();
	public static final String PUBLICATION = "PUBLICATION";
	public static final String USER = "USER";

	public static Object getParam(String name) {
		return context.get(name);
	}

	public static void putParam(String name, Object value) {
		context.put(name, value);
	}
}
