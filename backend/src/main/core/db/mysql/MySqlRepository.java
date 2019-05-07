package main.core.db.mysql;

import java.util.List;

import main.core.db.DataRepository;
import main.core.db.mysql.dao.BoredDao;
import main.core.db.mysql.mappers.ActivityMapper;
import main.core.db.mysql.mappers.ActivityTypeMapper;
import main.core.models.Activity;
import main.core.models.ActivityType;

public class MySqlRepository extends DataRepository {
	
	BoredDao dao;

	public MySqlRepository() {
		super();
		dao = new BoredDao();
	}

	@Override
	public void deleteActivity(final Activity activity) {
		dao.deleteActivity(activity);
	}

	@Override
	public Activity readActivityByKey(final int key) {
		return dao.readActivityByKey(key);
	}

	@Override
	public List<Activity> readAllActivities() {
		return dao.readAllActivities();
	}

	@Override
	public List<Activity> readAllActivitiesByAccessibility(final int accessibility) {
		return dao.readActivitiesByAccessibility(accessibility, accessibility);
	}

	@Override
	public List<Activity> readAllActivitiesByAccessibility(final int lowerBound, final int upperBound) {
		return dao.readActivitiesByAccessibility(lowerBound, upperBound);
	}

	@Override
	public List<Activity> readAllActivitiesByParticipants(final int participants) {
		return dao.readActivitiesByParticipants(participants, participants);
	}

	@Override
	public List<Activity> readAllActivitiesByParticipants(final int lowerBound, final int upperBound) {
		return dao.readActivitiesByParticipants(lowerBound, upperBound);
	}

	@Override
	public List<Activity> readAllActivitiesByPrice(final int price) {
		return dao.readActivitiesByPrice(price, price);
	}

	@Override
	public List<Activity> readAllActivitiesByPrice(final int lowerBound, final int upperBound) {
		return dao.readActivitiesByPrice(lowerBound, upperBound);
	}

	@Override
	public List<Activity> readAllActivitiesByType(final String activityType) {
		ActivityTypeMapper mapper = new ActivityTypeMapper();
		mapper.setName(activityType);
		return dao.readActivitiesByType(mapper);
	}

	@Override
	public void storeActivity(final Activity activity) {
		// TODO Auto-generated method stub
		dao.createActivity(activity);
	}

	@Override
	public void updateActivity(final Activity activity) {
		dao.updateActivity(new ActivityMapper(activity), new ActivityMapper(activity));
	}

	@Override
	public List<ActivityType> readAllActivityTypes() {
		return dao.readAllActivityTypes();
	}

	@Override
	public ActivityType readActivityTypeById(int id) {
		return dao.readActivityTypeById(id);
	}

	@Override
	public ActivityType readActivityTypeByName(String name) {
		return dao.readActivityTypeByName(name);
	}
}
