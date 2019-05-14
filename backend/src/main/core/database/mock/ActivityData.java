package main.core.database.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.core.exceptions.EntityNotUniqueException;
import main.models.Activity;

public class ActivityData {
	private List<Activity> activities;

	public ActivityData() {
		activities = new ArrayList<>();
		
		activities.add(new Activity("Test", 0.14, "Slingshot", 2, 0.79, "", 567284));
	}

	public void addActivity(Activity addActivity) throws EntityNotUniqueException {
		for (Activity activity : activities) {
			if(activity.getActivityKey() == addActivity.getActivityKey()) throw new EntityNotUniqueException();
			if(activity.getName().equals(addActivity.getName())) throw new EntityNotUniqueException();
		}
		this.activities.add(addActivity);
	}
	
	public void removeActivity(Activity removeActivity) {
		for(Activity activity : activities) {
			if(activity.getActivityKey() == removeActivity.getActivityKey()) this.activities.remove(activity);
		}
	}
	
	public void updateActivity(Activity updateActivity) {
		for(Activity activity : activities) {
			if(activity.getActivityKey() == updateActivity.getActivityKey()) activity = updateActivity;
		}
	}
	
	public Activity getActivityByKey(int key) {
		for(Activity activity : activities) {
			if(activity.getActivityKey() == key) return activity;
		}
		return null;
	}
	
	public Activity getActivityByName(String name) {
		for(Activity activity : activities) {
			if(activity.getName().contentEquals(name)) return activity;
		}
		return null;
	}
	
	public List<Activity> getAllActivities() {
		return Collections.unmodifiableList(this.activities);
	}
	
	public List<Activity> getAllActivitiesByAccessibility(double accessibility) {
		List<Activity> filteredActivities = new ArrayList<>();
		for(Activity activity : activities) {
			if(activity.getAccessibility() == accessibility) {
				filteredActivities.add(activity);
			}
		}
		return Collections.unmodifiableList(filteredActivities);
	}
	
	public List<Activity> getAllActivitiesByAccessibility(double lowerbound, double higherbound) {
		List<Activity> filteredActivities = new ArrayList<>();
		for(Activity activity : activities) {
			if(lowerbound < activity.getAccessibility() && activity.getAccessibility() < higherbound) {
				filteredActivities.add(activity);
			}
		}
		return Collections.unmodifiableList(filteredActivities);
	}
	
	public List<Activity> getAllActivitiesByParticipants(int participants) {
		List<Activity> filteredActivities = new ArrayList<>();
		for(Activity activity : activities) {
			if(activity.getParticipants() == participants) {
				filteredActivities.add(activity);
			}
		}
		return Collections.unmodifiableList(filteredActivities);
	}
	
	public List<Activity> getAllActivitiesByParticipants(int lowerbound, int higherbound) {
		List<Activity> filteredActivities = new ArrayList<>();
		for(Activity activity : activities) {
			if(lowerbound < activity.getParticipants() && activity.getParticipants() < higherbound) {
				filteredActivities.add(activity);
			}
		}
		return Collections.unmodifiableList(filteredActivities);
	}
	
	public List<Activity> getAllActivitiesByPrice(double price) {
		List<Activity> filteredActivities = new ArrayList<>();
		for(Activity activity : activities) {
			if(activity.getPrice() == price) {
				filteredActivities.add(activity);
			}
		}
		return Collections.unmodifiableList(filteredActivities);
	}
	
	public List<Activity> getAllActivitiesByPrice(double lowerbound, double higherbound) {
		List<Activity> filteredActivities = new ArrayList<>();
		for(Activity activity : activities) {
			if(lowerbound < activity.getPrice() && activity.getPrice() < higherbound) {
				filteredActivities.add(activity);
			}
		}
		return Collections.unmodifiableList(filteredActivities);
	}
	
	public List<Activity> getAllActivitiesByType(String activityType) {
		List<Activity> filteredActivities = new ArrayList<>();
		for(Activity activity : activities) {
			if(activity.getActivityType().contentEquals(activityType)) {
				filteredActivities.add(activity);
			}
		}
		return Collections.unmodifiableList(filteredActivities);
	}
}
