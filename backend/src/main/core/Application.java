package main.core;

public class Application {
	
	private static final String BASE_URL = "http://localhost";
	private static final int PORT = 8080;
	private static final String BASE_APPLICATION = "/bored";
	private static final String FULL_URL = BASE_URL + ":" + PORT + BASE_APPLICATION;

	public static void main(String[] args) {
		// Run code.
		System.out.println("Launched server on " + FULL_URL);
	}
}
