package main.core.db;

import java.util.List;

import main.core.models.ActivityType;

public interface DatabaseActivityTypeDao {
	ActivityType getActivityTypeById(int id);
	ActivityType getActivityTypeByName(String name);
	List<ActivityType> getAllActivityTypes();
	void addActivityType(ActivityType activityType);
	void updateActivityType(ActivityType activityType);
	void deleteActivityType(ActivityType activityType);
}
