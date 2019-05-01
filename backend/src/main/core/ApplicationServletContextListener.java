package main.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import main.api.bored.DataFetch;
import main.core.db.mysql.ActivityDao;
import main.core.models.Activity;

public class ApplicationServletContextListener implements ServletContextListener {
	
	ActivityDao activityDao = new ActivityDao();
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		//TODO: Replace Object[] with data mapper.
		for(int i = 0; i < 50; i += 1) {
			Object[] data = DataFetch.fetchData();
			activityDao.addUncheckedActivity((Activity)data[0]);
		}
		System.out.println("Application started.");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Application stopped.");
	}
}
