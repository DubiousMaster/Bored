package main.core.database;

import java.util.List;

import main.core.exceptions.EntityNotUniqueException;
import main.models.Activity;
import main.models.ActivityType;

/**
 * Define the methods all Repositories need to have.
 *
 * @author Alex Tigchelaar
 *
 */
public interface DataRepository {
	/**
	 * Delete an activity from the database.
	 *
	 * @param activity The activity to be removed.
	 */
	void deleteActivity(Activity activity);

	/**
	 * Read an activity by its unique Key.
	 *
	 * @param key The unique Key identifier of the activity.
	 * @return Returns the activity with the given key. Returns null if no activity
	 *         was found.
	 * @throws EntityNotUniqueException Thrown when trying to add a new entity but one or more of its unique values already exist in the data source. 
	 */
	Activity readActivityByKey(int key) throws EntityNotUniqueException;

	/**
	 * Read an activity by its unique Name.
	 *
	 * @param name The unique name of the activity.
	 * @return Returns the activity with the given name. Returns null if no activity
	 *         was found.
	 * @throws EntityNotUniqueException Thrown when trying to add a new entity but one or more of its unique values already exist in the data source. 
	 */
	Activity readActivityByName(String name) throws EntityNotUniqueException;

	/**
	 * Read an activity type by its unique name.
	 *
	 * @param name The unique name of the activity type.
	 * @return Returns the activity type with the given name. Returns null if no
	 *         activity was found.
	 * @throws EntityNotUniqueException Thrown when trying to add a new entity but one or more of its unique values already exist in the data source. 
	 */
	ActivityType readActivityTypeByName(String name) throws EntityNotUniqueException;

	/**
	 * Read all activities in the database.
	 *
	 * @return Returns a list of all activities in the data source.
	 */
	List<Activity> readAllActivities();

	/**
	 * Read all activities with the given accessibility value.
	 *
	 * @param accessibility The exact accessibility value the activities must have
	 *                      to be returned.
	 * @return Returns a list of all activities with the provided accessibility
	 *         value in the data source.
	 */
	List<Activity> readAllActivitiesByAccessibility(double accessibility);

	/**
	 * Read all activities with an accessiblity value between the lower and higher
	 * boundaries.
	 *
	 * @param lower  The lower, inclusive boundary the activities must be above to
	 *               be returned.
	 * @param higher The higher, inclusive boundary the activities must be below to
	 *               be returned.
	 * @return Returns a list of all activities between the provided accessibility
	 *         boundaries.
	 */
	List<Activity> readAllActivitiesByAccessibility(double lower, double higher);

	/**
	 * Read all activities with the given amount of participants required.
	 *
	 * @param participants The exact amount of participants required by an activity.
	 * @return Returns a list of all activities with the provided participants
	 *         requirement in the data source.
	 */
	List<Activity> readAllActivitiesByParticipants(int participants);

	/**
	 * Read all activities with a participant requirement between the lower and
	 * higher boundaries.
	 *
	 * @param lower  The lower, inclusive boundary the activities must be above to
	 *               be returned.
	 * @param higher The higher, inclusive boundary the activities must be below to
	 *               be returned.
	 * @return Returns a list of all activities between the provided participant
	 *         requirement boundaries.
	 */
	List<Activity> readAllActivitiesByParticipants(int lower, int higher);

	/**
	 * Read all activities with the given price.
	 *
	 * @param price The exact price the activities must have to be returned.
	 * @return Returns a list of all activities with the provided price in the data
	 *         source.
	 */
	List<Activity> readAllActivitiesByPrice(double price);

	/**
	 * Read all activities with a price between the lower and higher boundaries.
	 *
	 * @param lower  The lower, inclusive boundary the activities must be above to
	 *               be returned.
	 * @param higher The higher, inclusibe boundary the activities must be below to
	 *               be returned.
	 * @return Returns a list of all activities with a price between the given
	 *         boundaries.
	 */
	List<Activity> readAllActivitiesByPrice(double lower, double higher);

	/**
	 * Read all activities with the specified activity type.
	 *
	 * @param activityType The activity type.
	 * @return Returns a list of all activities that are part of the given type.
	 */
	List<Activity> readAllActivitiesByType(ActivityType activityType);

	/**
	 * Read all activities with the specified type name.
	 *
	 * @param activityType The name of the activity type.
	 * @return Returns a list of all activities that are part of the given type.
	 */
	List<Activity> readAllActivitiesByType(String activityType);

	/**
	 * Read all activity types from the data source.
	 *
	 * @return Returns a list of all activity types.
	 */
	List<ActivityType> readAllActivityTypes();

	/**
	 * Create a new activity in the data source.
	 *
	 * @param activity The activity to be newly added to the data source.
	 */
	void storeActivity(Activity activity);

	/**
	 * Create a new activity type in the data source.
	 * 
	 * @param activityType The activity type to be newly added to the data source.
	 */
	void storeActivityType(ActivityType activityType);

	/**
	 * Update an existing activity in the data source.
	 *
	 * @param activity The activity to be updated.
	 */
	void updateActivity(Activity activity);

	/**
	 * Update an existing activity type in the data source.
	 * 
	 * @param activityType The activity type to be updated.
	 */
	void updateActivityType(ActivityType activityType);
}
