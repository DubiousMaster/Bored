package main.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import main.api.bored.DataFetch;
import main.core.db.mysql.MySqlRepository;
import main.core.db.mysql.dao.BoredDao;
import main.core.models.Activity;

public class ApplicationServletContextListener implements ServletContextListener {

	BoredDao boredDao = new BoredDao();

	@Override
	public void contextDestroyed(final ServletContextEvent arg0) {
		System.out.println("Application stopped.");
	}

	@Override
	public void contextInitialized(final ServletContextEvent arg0) {

		// TODO: Replace Object[] with data mapper.
		for(int i = 0; i < 20; i += 1) {
			Activity data = DataFetch.fetchData();
			new MySqlRepository().storeActivity(data);
		}
		System.out.println("Application started.");
	}
}
