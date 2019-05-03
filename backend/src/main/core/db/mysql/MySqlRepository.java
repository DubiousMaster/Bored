package main.core.db.mysql;

import java.util.List;

import main.core.db.DataRepository;
import main.core.models.Activity;

public class MySqlRepository extends DataRepository {

	public MySqlRepository() {
		super();
	}

	@Override
	public void deleteActivity(Activity activity) {
		// TODO Auto-generated method stub
	}

	@Override
	public Activity readActivityById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activity readActivityByKey(int key) {
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
	public void storeActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}
}
