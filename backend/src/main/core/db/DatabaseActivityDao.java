package main.core.db;

import java.util.List;

import main.core.models.Activity;

public interface DatabaseActivityDao {
	Activity getActivityById(int id);
	Activity getActivityByKey(int key);
	List<Activity> getAllActivities();
	void addActivity(Activity activity);
	void updateActivity(Activity activity);
	void deleteActivity(Activity activity);
}
