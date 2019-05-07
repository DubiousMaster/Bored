package main.core.db;

import java.util.List;

import main.core.db.mock.MockRepository;
import main.core.db.mysql.MySqlRepository;
import main.core.models.Activity;
import main.core.models.ActivityType;

public abstract class DataRepository {
	
	// TODO: Implement singleton
	public static final DataRepository getDataRepository(final DBTypes databaseType) {
		switch (databaseType) {
		case MOCK:
			return new MockRepository();
		case MY_SQL:
			return new MySqlRepository();
		default:
			return null;
		}
	}

	protected DataRepository() {
	}

	public abstract void deleteActivity(Activity activity);

	public abstract Activity readActivityByKey(int key);
	
	public abstract ActivityType readActivityTypeById(int id);
	
	public abstract ActivityType readActivityTypeByName(String name);

	public abstract List<Activity> readAllActivities();

	public abstract List<Activity> readAllActivitiesByAccessibility(int accessibility);

	public abstract List<Activity> readAllActivitiesByAccessibility(int lowerBound, int upperBound);

	public abstract List<Activity> readAllActivitiesByParticipants(int participants);

	public abstract List<Activity> readAllActivitiesByParticipants(int lowerBound, int upperBound);

	public abstract List<Activity> readAllActivitiesByPrice(int price);

	public abstract List<Activity> readAllActivitiesByPrice(int lowerBound, int upperBound);

	public abstract List<Activity> readAllActivitiesByType(String activityType);
	
	public abstract List<ActivityType> readAllActivityTypes();

	public abstract void storeActivity(Activity activity);

	public abstract void updateActivity(Activity activity);
}
