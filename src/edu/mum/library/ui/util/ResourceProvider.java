package edu.mum.library.ui.util;

import java.net.URL;

public class ResourceProvider {

	private static final String HOME = "/edu/mum/library/ui/Home.fxml";
	private static final String LOGIN = "/edu/mum/library/ui/Login.fxml";
	private static final String BOOK = "/edu/mum/library/ui/Book.fxml";
	private static final String PERIODIC = "/edu/mum/library/ui/Periodic.fxml";

	private static URL getResource(String url) {
		return ResourceProvider.class.getResource(url);
	}

	public static URL getHome() {
		return getResource(HOME);
	}

	public static URL getLogin() {
		return getResource(LOGIN);
	}

	public static URL getBook() {
		return getResource(BOOK);
	}
	
	public static URL getPeriodic(){
		return getResource(PERIODIC);
	}

}
