package main.core.database.mock;

import java.util.List;

import main.core.database.DataRepository;
import main.core.exceptions.EntityNotUniqueException;
import main.models.Activity;
import main.models.ActivityType;

public class MockRepository implements DataRepository {

	private static ActivityData activityData = new ActivityData();
	private static ActivityTypeData activityTypeData = new ActivityTypeData();

	@Override
	public void deleteActivity(final Activity activity) {
		activityData.removeActivity(activity);
	}

	@Override
	public Activity readActivityByKey(final int key) {
		return activityData.getActivityByKey(key);
	}

	@Override
	public Activity readActivityByName(final String name) {
		return activityData.getActivityByName(name);
	}

	@Override
	public ActivityType readActivityTypeByName(final String name) {
		return activityTypeData.getActivityTypeByName(name);
	}

	@Override
	public List<Activity> readAllActivities() {
		return activityData.getAllActivities();
	}

	@Override
	public List<Activity> readAllActivitiesByAccessibility(final double accessibility) {
		return activityData.getAllActivitiesByAccessibility(accessibility);
	}

	@Override
	public List<Activity> readAllActivitiesByAccessibility(final double lower, final double higher) {
		return activityData.getAllActivitiesByAccessibility(lower, higher);
	}

	@Override
	public List<Activity> readAllActivitiesByParticipants(final int participants) {
		return activityData.getAllActivitiesByParticipants(participants);
	}

	@Override
	public List<Activity> readAllActivitiesByParticipants(final int lower, final int higher) {
		return activityData.getAllActivitiesByParticipants(lower, higher);
	}

	@Override
	public List<Activity> readAllActivitiesByPrice(final double price) {
		return activityData.getAllActivitiesByPrice(price);
	}

	@Override
	public List<Activity> readAllActivitiesByPrice(final double lower, final double higher) {
		return activityData.getAllActivitiesByPrice(lower, higher);
	}

	@Override
	public List<Activity> readAllActivitiesByType(final ActivityType activityType) {
		return activityData.getAllActivitiesByType(activityType.getName());
	}

	@Override
	public List<Activity> readAllActivitiesByType(final String activityType) {
		return activityData.getAllActivitiesByType(activityType);
	}

	@Override
	public List<ActivityType> readAllActivityTypes() {
		return activityTypeData.getAllActivityTypes();
	}

	@Override
	public void storeActivity(final Activity activity) {
		try {
			activityData.addActivity(activity);
		} catch (EntityNotUniqueException e) {
			System.out.println("Could not store activity. The activity already exists.");
		}
	}

	@Override
	public void storeActivityType(final ActivityType activityType) {
		try {
			activityTypeData.addActivityType(activityType);
		} catch (EntityNotUniqueException e) {
			System.out.println("Could not store activity type. The activity type already exists.");
		}
	}

	@Override
	public void updateActivity(final Activity activity) {
		activityData.updateActivity(activity);
	}

	@Override
	public void updateActivityType(final ActivityType activityType) {
		activityTypeData.updateActivityType(activityType);
	}
}
