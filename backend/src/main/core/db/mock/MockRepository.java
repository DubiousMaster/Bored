package main.core.db.mock;

import java.util.List;

import main.core.db.DataRepository;
import main.core.models.Activity;
import main.core.models.ActivityType;

public class MockRepository extends DataRepository {

	@Override
	public void deleteActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Activity readActivityByKey(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityType readActivityTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityType readActivityTypeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> readAllActivities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> readAllActivitiesByAccessibility(int accessibility) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> readAllActivitiesByAccessibility(int lowerBound, int upperBound) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> readAllActivitiesByParticipants(int participants) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> readAllActivitiesByParticipants(int lowerBound, int upperBound) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> readAllActivitiesByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> readAllActivitiesByPrice(int lowerBound, int upperBound) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> readAllActivitiesByType(String activityType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityType> readAllActivityTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}
}
