package main.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import main.core.db.mysql.ActivityDao;

public class ApplicationServletContextListener implements ServletContextListener {

	ActivityDao activityDao = new ActivityDao();

	@Override
	public void contextDestroyed(final ServletContextEvent arg0) {
		System.out.println("Application stopped.");
	}

	@Override
	public void contextInitialized(final ServletContextEvent arg0) {

		// TODO: Replace Object[] with data mapper.
//		for(int i = 0; i < 5; i += 1) {
//			Object[] data = DataFetch.fetchData();
//			activityDao.addUncheckedActivity((Activity)data[0]);
//		}
		System.out.println("Application started.");
	}
}
