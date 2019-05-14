package main.core.database.mysql;

import java.util.ArrayList;
import java.util.List;

import main.core.database.DataRepository;
import main.core.database.mysql.dao.BoredDao;
import main.core.database.mysql.mappers.ActivityMapper;
import main.core.database.mysql.mappers.ActivityTypeMapper;
import main.core.exceptions.EntityNotUniqueException;
import main.models.Activity;
import main.models.ActivityType;

public class MySqlRepository implements DataRepository {
	
	private BoredDao dao = new BoredDao();

	@Override
	public void deleteActivity(final Activity activity) {
		dao.deleteActivity(new ActivityMapper(activity));
	}

	@Override
	public Activity readActivityByKey(final int key) throws EntityNotUniqueException {
		return dao.readActivityByKey(key).toEntity();
	}

	@Override
	public Activity readActivityByName(final String name) throws EntityNotUniqueException {
		return dao.readActivityByName(name).toEntity();
	}

	public ActivityType readActivityTypeById(final int id) throws EntityNotUniqueException {
		return dao.readActivityTypeById(id).toEntity();

	}

	@Override
	public ActivityType readActivityTypeByName(final String name) throws EntityNotUniqueException {
		return dao.readActivityTypeByName(name).toEntity();
	}

	@Override
	public List<Activity> readAllActivities() {
		List<Activity> activities = new ArrayList<>();
		for(ActivityMapper mapper : dao.readAllActivities()) {
			activities.add(mapper.toEntity());
		}
		return activities;
	}

	@Override
	public List<Activity> readAllActivitiesByAccessibility(final double accessibility) {
		List<Activity> activities = new ArrayList<>();
		for(ActivityMapper mapper : dao.readActivitiesByAccessibility(accessibility)) {
			activities.add(mapper.toEntity());
		}
		return activities;
	}

	@Override
	public List<Activity> readAllActivitiesByAccessibility(final double lower, final double higher) {
		List<Activity> activities = new ArrayList<>();
		for(ActivityMapper mapper : dao.readActivitiesByAccessibility(lower, higher)) {
			activities.add(mapper.toEntity());
		}
		return activities;
	}

	@Override
	public List<Activity> readAllActivitiesByParticipants(final int participants) {
		List<Activity> activities = new ArrayList<>();
		for(ActivityMapper mapper : dao.readActivitiesByParticipants(participants)) {
			activities.add(mapper.toEntity());
		}
		return activities;
	}

	@Override
	public List<Activity> readAllActivitiesByParticipants(final int lower, final int higher) {
		 List<Activity> activities = new ArrayList<>();
		 for(ActivityMapper mapper : dao.readActivitiesByParticipants(lower, higher)) {
			 activities.add(mapper.toEntity());
		 }
		 return activities;
	}

	@Override
	public List<Activity> readAllActivitiesByPrice(final double price) {
		List<Activity> activities = new ArrayList<>();
		 for(ActivityMapper mapper : dao.readActivitiesByPrice(price)) {
			 activities.add(mapper.toEntity());
		 }
		 return activities;
	}

	@Override
	public List<Activity> readAllActivitiesByPrice(final double lower, final double higher) {
		List<Activity> activities = new ArrayList<>();
		 for(ActivityMapper mapper : dao.readActivitiesByPrice(lower, higher)) {
			 activities.add(mapper.toEntity());
		 }
		 return activities;
	}

	@Override
	public List<Activity> readAllActivitiesByType(final ActivityType activityType) {
		List<Activity> activities = new ArrayList<>();
		 for(ActivityMapper mapper : dao.readActivitiesByType(new ActivityTypeMapper(activityType))) {
			 activities.add(mapper.toEntity());
		 }
		 return activities;
	}

	@Override
	public List<Activity> readAllActivitiesByType(final String activityType) {
		List<Activity> activities = new ArrayList<>();
		 for(ActivityMapper mapper : dao.readActivitiesByType(activityType)) {
			 activities.add(mapper.toEntity());
		 }
		 return activities;
	}

	@Override
	public List<ActivityType> readAllActivityTypes() {
		List<ActivityType> activities = new ArrayList<>();
		 for(ActivityTypeMapper mapper : dao.readAllActivityTypes()) {
			 activities.add(mapper.toEntity());
		 }
		 return activities;
	}

	@Override
	public void storeActivity(final Activity activity) {
		ActivityTypeMapper activityTypeMapper = new ActivityTypeMapper();
		activityTypeMapper.setName(activity.getActivityType());
		dao.createActivityType(activityTypeMapper);
		dao.createActivity(new ActivityMapper(activity));
	}

	@Override
	public void storeActivityType(final ActivityType activityType) {
		dao.createActivityType(new ActivityTypeMapper(activityType));
	}

	@Override
	public void updateActivity(final Activity activity) {
		dao.updateActivity(new ActivityMapper(activity));
	}

	@Override
	public void updateActivityType(final ActivityType activityType) {
		dao.updateActivityType(new ActivityTypeMapper(activityType));
	}
}
