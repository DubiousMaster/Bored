package main.core.database.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.core.exceptions.EntityNotUniqueException;
import main.models.ActivityType;

public class ActivityTypeData {
	private static List<ActivityType> activityTypeData;
	
	public ActivityTypeData() {
		activityTypeData = new ArrayList<>();
	}
	
	public void deleteActivityType(ActivityType deleteActivityType) {
		for(ActivityType activityType : activityTypeData) {
			if(activityType.getName().contentEquals(deleteActivityType.getName())) {
				activityTypeData.remove(activityType);
				break;
			}
		}
	}
	
	public void addActivityType(ActivityType addActivityType) throws EntityNotUniqueException {
		for(ActivityType activityType : activityTypeData) {
			if(activityType.getName().contentEquals(addActivityType.getName())) throw new EntityNotUniqueException();
		}
		activityTypeData.add(addActivityType);
	}
	
	public void updateActivityType(ActivityType updateActivityType) {
		// For now, this method is redundant. It is impossible to update the name of one object without any unique identifiers.
		throw new UnsupportedOperationException();
	}
	
	public ActivityType getActivityTypeByName(String name) {
		for(ActivityType activityType : activityTypeData) {
			if(activityType.getName().contentEquals(name)) return activityType;
		}
		return null;
	}
	
	public List<ActivityType> getAllActivityTypes() {
		return Collections.unmodifiableList(activityTypeData);
	}
}
