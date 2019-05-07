package main.core.db.mysql.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.core.db.Database;
import main.core.db.models.Table;
import main.core.db.models.TableFactory;
import main.core.db.mysql.MySqlDatabase;
import main.core.db.mysql.MySqlQueryBuilder;
import main.core.db.mysql.mappers.ActivityMapper;
import main.core.db.mysql.mappers.ActivityTypeMapper;
import main.core.models.Activity;
import main.core.models.ActivityType;

/**
 * Execute queries on the Bored database.
 * 
 * @author Alex Tigchelaar
 */
public final class BoredDao {

	/**
	 * Store all data from the ActivityTypeMapper into the database.
	 * 
	 * @param mapper The data that needs to be stored in the database.
	 */
	private final void createActivityType(final ActivityTypeMapper mapper) {
		try (Database db = new MySqlDatabase()) {
			
			Table table = TableFactory.createTable("ActivityType", "Name");
			
			final String sql = MySqlQueryBuilder.buildInsertQuery(table);
			db.execute(sql, new Object[] { mapper.getName() });
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Store all data from the ActivityMapper into the database.
	 * 
	 * @param mapper The data that needs to be stored in the database.
	 */
	private final void createActivity(final ActivityMapper mapper) {
		try (Database db = new MySqlDatabase()) {
			
			Table table = TableFactory.createTable("Activity", "Name", "Accessibility", "ActivityTypeId", "Participants", "Price", "Link", "ActivityKey");
			
			final String sql = MySqlQueryBuilder.buildInsertQuery(table);
			db.execute(sql, new Object[] { mapper.getName(), mapper.getAccessibility(), mapper.getActivityTypeId(),
					mapper.getParticipants(), mapper.getPrice(), mapper.getLink(), mapper.getActivityKey() });
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Store all data from the activity into the database.
	 * 
	 * @param activity The data that needs to be stored in the database.
	 */
	public final void createActivity(final Activity activity) {
		ActivityMapper activityMapper = new ActivityMapper(activity);
		ActivityTypeMapper activityTypeMapper = new ActivityTypeMapper(activity);
		
		this.createActivityType(activityTypeMapper);

//		activityMapper.setActivityTypeId(this.readActivityType(activity).g);

		this.createActivity(activityMapper);
	}

	/**
	 * Collect one line of data from the ActivityType table in the database.
	 * 
	 * @param id The unique ID value of the activity type.
	 * @return Returns a string with the activity type name.
	 */
	public final ActivityType readActivityTypeById(final int id) {
		try (Database db = new MySqlDatabase()) {
			
			List<Table> tables = new ArrayList<>();
			tables.add(TableFactory.createTable("ActivityType", "Id", "Name"));
			
			List<Table> where = new ArrayList<>();
			where.add(TableFactory.createTable("ActivityType", "Id"));
			
			final String sql = MySqlQueryBuilder.buildSelectQuery(tables, where);
			ResultSet set = db.executeQuery(sql, new Object[] { id });
			while(set.next()) {
			return new ActivityTypeMapper().fillMapper(set).toEntity();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO: fetch data.
		return null;
	}

	/**
	 * Collect one line of data from the ActivityType table in the database.
	 * 
	 * @param name The unique name of the activity type.
	 * @return Returns a string with the activity type name.
	 */
	public final ActivityType readActivityTypeByName(final String name) {
		try (Database db = new MySqlDatabase()) {
			
			List<Table> tables = new ArrayList<>();
			tables.add(TableFactory.createTable("ActivityType", "Id", "Name"));
			
			List<Table> where = new ArrayList<>();
			where.add(TableFactory.createTable("ActivityType", "Name"));
			
			final String sql = MySqlQueryBuilder.buildSelectQuery(tables, where);
			ResultSet set = db.executeQuery(sql, new Object[] { name });
			while(set.next()) {
			return new ActivityTypeMapper().fillMapper(set).toEntity();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final ActivityType readActivityType(final ActivityType activityType) {
		if (activityType.getName() != null && activityType.getName() != "") {
			return this.readActivityTypeByName(activityType.getName());
		}
		return null;
	}

	public final ActivityType readActivityType(final Activity activity) {
		if (activity.getActivityType() != null && activity.getActivityType() != "") {
			return this.readActivityTypeByName(activity.getActivityType());
		}
		return null;
	}

	/**
	 * Collect one line of data from the Activity table in the database.
	 * 
	 * @param name The unique name of the activity.
	 * @return Returns an activity with all collected data.
	 */
	public final ActivityMapper readActivityByName(final String name) {
		try (Database db = new MySqlDatabase()) {
			
			List<Table> tables = new ArrayList<>();
			tables.add(TableFactory.createTable("Activity", "Id", "Name", "Accessibility", "ActivityTypeId", "Participants", "Price", "Link", "ActivityKey"));
			
			List<Table> where = new ArrayList<>();
			where.add(TableFactory.createTable("Activity", "Name"));
			
			final String sql = MySqlQueryBuilder.buildSelectQuery(tables, where);
			ResultSet set = db.executeQuery(sql, new Object[] { name });
			while(set.next()) {
			return new ActivityMapper().fillMapper(set);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Collect one line of data from the Activity table in the database.
	 * 
	 * @param key The unique key of the activity.
	 * @return Returns an activity with all collected data.
	 */
	public final Activity readActivityByKey(final int key) {
		try (Database db = new MySqlDatabase()) {
			
			List<Table> tables = new ArrayList<>();
			tables.add(TableFactory.createTable("Activity", "Id", "Name", "Accessibility", "ActivityTypeId", "Participants", "Price", "Link", "ActivityKey"));
			
			List<Table> where = new ArrayList<>();
			where.add(TableFactory.createTable("Activity", "Key"));
			
			final String sql = MySqlQueryBuilder.buildSelectQuery(tables, where);
			ResultSet set = db.executeQuery(sql, new Object[] { key });
			while(set.next()) {
			return new ActivityMapper().fillMapper(set).toEntity();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Collect one line of data from the Activity table in the database.
	 * 
	 * @param activity Incomplete activity data to collect from the database.
	 * @return Returns an activity with all collected data.
	 */
	public final Activity readActivity(final Activity activity) {
		Activity readActivity = null;

		if (activity.getName() != null && activity.getName() != "") {
			readActivity = this.readActivityByName(activity.getName()).toEntity();
		} else if (activity.getActivityKey() > -1) {
			readActivity = this.readActivityByKey(activity.getActivityKey());
		}
		this.readActivityType(activity);

		return readActivity;
	}

	/**
	 * Collect all data from the ActivityType table in the database.
	 * 
	 * @return Returns a list of activities with all collected data.
	 */
	public final List<ActivityType> readAllActivityTypes() {
		List<ActivityType> activityTypes = new ArrayList<>();
		// TODO: fetch data.
		return activityTypes;
	}

	/**
	 * Collect all data from the Activity table in the database.
	 * 
	 * @return Returns a list of activities with all collected data.
	 */
	public final List<Activity> readAllActivities() {
		List<Activity> activities = new ArrayList<>();

		try (Database db = new MySqlDatabase()) {
			List<Table> tables = new ArrayList<>();
			tables.add(TableFactory.createTable("Activity", "Id", "Name", "Accessibility", "ActivityTypeId", "Participants", "Price", "Link", "ActivityKey"));
			
			final String sql = MySqlQueryBuilder.buildSelectQuery(tables);
			ResultSet set = db.executeQuery(sql);
			
			while(set.next()) {
				activities.add(new ActivityMapper().fillMapper(set).toEntity());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activities;
	}

	/**
	 * Collect all data from the Activity table in the database with an
	 * accessibility between the provided values.
	 * 
	 * @param lowerbound The lower boundary of the accessibility.
	 * @param upperbound The upper boundary of the accessibility.
	 * @return Returns a list of activities with all collected data.
	 */
	public final List<Activity> readActivitiesByAccessibility(final double lowerbound, final double upperbound) {
		List<Activity> activities = new ArrayList<>();
		// TODO: fetch data.
		return activities;
	}

	/**
	 * Collect all data from the Activity table in the database that refers to a
	 * certain type.
	 * 
	 * @param activityTypeName The unique name of the activity type.
	 * @return Returns a list of activities with all collected data.
	 */
	private final List<Activity> readActivitiesByType(final String activityTypeName) {
		List<Activity> activities = new ArrayList<>();
		// TODO: fetch data.
		return activities;
	}

	/**
	 * Collect all data from the Activity table in the database that refers to a
	 * certain type.
	 * 
	 * @param activity An activity that all activities need to share type with.
	 * @return Returns a list of activities with all collected data.
	 */
	public final List<Activity> readActivitiesByType(final Activity activity) {
		List<Activity> activities = new ArrayList<>();
		if (activity.getActivityType() != null && activity.getActivityType() != "") {
			activities.addAll(this.readActivitiesByType(activity.getActivityType()));
		}
		// TODO: fetch data.
		return activities;
	}

	/**
	 * Collect all data from the Activity table in the database that refers to a
	 * certain type.
	 * 
	 * @param activityTypeMapper The activity type data related to by the activity.
	 * @return Returns a list of activities with all collected data.
	 */
	public final List<Activity> readActivitiesByType(final ActivityTypeMapper activityTypeMapper) {
		List<Activity> activities = new ArrayList<>();
		// TODO: fetch data.
		return activities;
	}

	/**
	 * Collect all data from the Activity table in the database with an amount of
	 * participants between the provided values.
	 * 
	 * @param lowerbound The lower boundary of the amount of participants.
	 * @param upperbound The upper boundary of the amount of participants.
	 * @return Returns a list of activities with all collected data.
	 */
	public final List<Activity> readActivitiesByParticipants(final int lowerbound, final int upperbound) {
		List<Activity> activities = new ArrayList<>();
		// TODO: fetch data.
		return activities;
	}

	/**
	 * Collect all data from the Activity table in the database with a price between
	 * the provided values.
	 * 
	 * @param lowerbound The lower boundary of the prices.
	 * @param upperbound The upper boundary of the prices.
	 * @return Returns a list of activities with all collected data.
	 */
	public final List<Activity> readActivitiesByPrice(final double lowerbound, final double upperbound) {
		List<Activity> activities = new ArrayList<>();
		// TODO: fetch data.
		return activities;
	}

	/**
	 * Update the activity type data on the given activity type identifier.
	 * 
	 * @param activityTypeId The unique ID value of the activity type to update.
	 * @param activityType   The activity type data that's used to update the old
	 *                       data.
	 */
	public final void updateActivityTypeById(final int activityTypeId, final ActivityTypeMapper activityType) {
		// TODO: update data.
	}

	/**
	 * Update the activity type data on the given name.
	 * 
	 * @param activityTypeName The unique name of the activity type to update.
	 * @param activityType     The activity type data that's used to update the old
	 *                         data.
	 */
	public final void updateActivityTypeByName(final String activityTypeName, final ActivityTypeMapper activityType) {
		// TODO: update data.
	}

	/**
	 * Update the activity type data from the old activity type data.
	 * 
	 * @param oldActivityType The old activity type data.
	 * @param newActivityType The activity type data that's used to update the old
	 *                        data.
	 */
	public final void updateActivityType(final ActivityTypeMapper oldActivityType,
			final ActivityTypeMapper newActivityType) {
		// TODO: update data.
	}

	/**
	 * Update the activity data on the given activity identifier.
	 * 
	 * @param activityId The unique ID value of the activity to update.
	 * @param activity   The activity data that's used to update the old data.
	 */
	public final void updateActivityById(final int activityId, final ActivityMapper activity) {
		// TODO: update data.
	}

	/**
	 * Update the activity data on the given name.
	 * 
	 * @param activityName The unique name of the activity to update.
	 * @param activity     The activity data that's used to update the old data.
	 */
	public final void updateActivityByName(final String activityName, final ActivityMapper activity) {
		// TODO: update data.
	}

	/**
	 * Update the activity data on the given key.
	 * 
	 * @param activityKey The unique key of the activity to update.
	 * @param activity    The activity data that's used to update the old data.
	 */
	public final void updateActivityByKey(final int activityKey, final ActivityMapper activity) {
		// TODO: update data.
	}

	/**
	 * Update the activity data from the old activity data.
	 * 
	 * @param oldActivity The old activity data.
	 * @param newActivity The activity data that's used to update the old data.
	 */
	public final void updateActivity(final ActivityMapper oldActivity, final ActivityMapper newActivity) {
		// TODO: update data.
	}

	/**
	 * Remove the activity type data with the given ID value.
	 * 
	 * @param id The unique ID value of the activity type to be removed from the
	 *           database.
	 */
	public final void deleteActivityTypeById(final int id) {
		// TODO: remove data.
	}

	/**
	 * Remove the activity type data with the given name.
	 * 
	 * @param name The unique name of the activity type to be removed from the
	 *             database.
	 */
	private final void deleteActivityTypeByName(final String name) {
		// TODO: remove data.
	}

	/**
	 * Remove the activity type data with the given activity data.
	 * 
	 * @param activity The activity data containing the activity type data.
	 */
	public final void deleteActivityType(final Activity activity) {
		this.deleteActivityTypeByName(activity.getActivityType());
		// TODO: remove data.
	}

	/**
	 * Remove the activity type data with the given data.
	 * 
	 * @param activityType The activity type data to be removed from the database.
	 */
	public final void deleteActivityType(final ActivityTypeMapper activityType) {
		this.deleteActivityTypeByName(activityType.getName());
		// TODO: remove data.
	}

	/**
	 * Remove the activity data with the given ID value.
	 * 
	 * @param id The unique ID value of the activity to be removed from the
	 *           database.
	 */
	public final void deleteActivityById(final int id) {
		// TODO: remove data.
	}

	/**
	 * Remove the activity data with the given name.
	 * 
	 * @param name The unique name of the activity to be removed from the database.
	 */
	public final void deleteActivityByName(final String name) {
		// TODO: remove data.
	}

	/**
	 * Remove the activity data with the given key.
	 * 
	 * @param key The unique key of the activity to be removed from the database.
	 */
	public final void deleteActivityByKey(final int key) {
		// TODO: remove data.
	}

	/**
	 * Remove the activity data with the given data.
	 * 
	 * @param activity The activity data to be removed from the database.
	 */
	public final void deleteActivity(final Activity activity) {
		// TODO: remove data.
	}

	/**
	 * Remove the activity data with the given data.
	 * 
	 * @param activity The activity data to be removed from the database.
	 */
	public final void deleteActivity(final ActivityMapper activity) {
		// TODO: remove data.
	}
}
