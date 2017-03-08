package edu.mum.library.ui.util;

import java.util.HashMap;
import java.util.Map;

public final class AppContext {

	private AppContext() {
	}

	private final static Map<String, Object> context = new HashMap<>();

	public static Object getParam(String name) {
		return context.get(name);
	}

	public static void putParam(String name, Object value) {
context.put(name, value);
	}
}