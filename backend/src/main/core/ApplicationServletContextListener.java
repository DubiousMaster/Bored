package main.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * This class is listens to server events. When the server boots up,
 * contextInitialized is called. When the server is shutting down,
 * contextDestroyed is called.
 * 
 * @author Alex Tigchelaar
 *
 */
public final class ApplicationServletContextListener implements ServletContextListener {
	/**
	 * This code runs when shutting down the server.
	 */
	@Override
	public final void contextDestroyed(final ServletContextEvent arg0) {
		System.out.println("Application stopped.");
	}

	/**
	 * This code runs when the server is booting up.
	 */
	@Override
	public final void contextInitialized(final ServletContextEvent arg0) {
		Application.main(null);
		System.out.println("Application started.");
	}
}
