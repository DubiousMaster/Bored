package main.core.database.mysql.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.core.database.Database;
import main.core.database.mysql.managers.MySqlDatabaseFactory;
import main.core.database.mysql.managers.MySqlDatabaseVersions;
import main.core.database.mysql.mappers.ActivityMapper;
import main.core.database.mysql.mappers.ActivityTypeMapper;
import main.core.database.mysql.query.MySqlQueryBuilder;
import main.core.exceptions.EntityNotUniqueException;
import main.util.Pair;

public final class BoredDao implements Dao {
	private final MySqlDatabaseVersions dbVersion = MySqlDatabaseVersions.MySqlDatabase;

	public final void createActivity(final ActivityMapper activity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> insertValues = Arrays.asList("Name", "Accessibility", "ActivityTypeId", "Participants",
					"Price", "Link", "ActivityKey");
			final String sql = MySqlQueryBuilder.buildInsertQuery(new Pair<>("Activity", insertValues));
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Name", activity.getName()),
					new Pair<>("Accessibility", activity.getAccessibility()),
					new Pair<>("ActivityTypeId", activity.getActivityTypeId()),
					new Pair<>("Participants", activity.getParticipants()), new Pair<>("Price", activity.getPrice()),
					new Pair<>("Link", activity.getLink()), new Pair<>("ActivityKey", activity.getActivityKey()));
			db.executeInsert(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void createActivityType(final ActivityTypeMapper activityType) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> insertValues = Arrays.asList("Name");
			final String sql = MySqlQueryBuilder.buildInsertQuery(new Pair<>("ActivityType", insertValues));
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Name", activityType.getName()));
			db.executeInsert(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void deleteActivity(final ActivityMapper activity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> deleteValues = new ArrayList<>();
			final List<Pair<String, Object>> params = new ArrayList<>();
			if (activity.getId() > 0) {
				deleteValues.add("Id");
				params.add(new Pair<>("Id", activity.getId()));
			}
			if (activity.getActivityKey() > 0) {
				deleteValues.add("ActivityKey");
				params.add(new Pair<>("ActivityKey", activity.getActivityKey()));
			}
			if (!activity.getName().contentEquals("")) {
				deleteValues.add("Name");
				params.add(new Pair<>("Name", activity.getName()));
			}
			final String sql = MySqlQueryBuilder.buildDeleteQuery(new Pair<>("Activity", deleteValues));
			db.execute(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void deleteActivityById(final int id) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> deleteValues = Arrays.asList("Id");
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Id", id));
			final String sql = MySqlQueryBuilder.buildDeleteQuery(new Pair<>("Activity", deleteValues));
			db.execute(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void deleteActivityByKey(final int key) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> deleteValues = Arrays.asList("ActivityKey");
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("ActivityKey", key));
			final String sql = MySqlQueryBuilder.buildDeleteQuery(new Pair<>("Activity", deleteValues));
			db.execute(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void deleteActivityByName(final String name) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> deleteValues = Arrays.asList("Name");
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Name", name));
			final String sql = MySqlQueryBuilder.buildDeleteQuery(new Pair<>("Activity", deleteValues));
			db.execute(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void deleteActivityType(final ActivityTypeMapper activityType) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> deleteValues = new ArrayList<>();
			final List<Pair<String, Object>> params = new ArrayList<>();
			if (activityType.getId() > 0) {
				deleteValues.add("Id");
				params.add(new Pair<>("Id", activityType.getId()));
			}
			if (!activityType.getName().contentEquals("")) {
				deleteValues.add("Name");
				params.add(new Pair<>("Name", activityType.getName()));
			}
			final String sql = MySqlQueryBuilder.buildDeleteQuery(new Pair<>("ActivityType", deleteValues));
			db.execute(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void deleteActivityTypeById(final int id) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> deleteValues = Arrays.asList("Id");
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Id", id));
			final String sql = MySqlQueryBuilder.buildDeleteQuery(new Pair<>("ActivityType", deleteValues));
			db.execute(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void deleteActivityTypeByName(final String name) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<String> deleteValues = Arrays.asList("Name");
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Name", name));
			final String sql = MySqlQueryBuilder.buildDeleteQuery(new Pair<>("ActivityType", deleteValues));
			db.execute(sql, params);
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final List<ActivityMapper> readActivitiesByAccessibility(final ActivityMapper sampleActivity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(this.dbVersion)) {
			final List<Pair<String, List<String>>> readValues = new ArrayList<>();
			readValues.add(new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = new ArrayList<>();
			whereValues.add(new Pair<>("Activity", Arrays.asList("Accessibility")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Accessibility", sampleActivity.getAccessibility()));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByAccessibility(final double exactValue) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("Accessibility")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Accessibility", exactValue));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByAccessibility(final double lowerbound, final double higherbound) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("*")));
			final String where = " WHERE Activity.Accessibility > ? AND Activity.Accessibility < ?";
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues) + where;
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Accessibility", lowerbound), new Pair<>("Accessibility", higherbound));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByParticipants(final ActivityMapper sampleActivity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("Participants")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Participants", sampleActivity.getParticipants()));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByParticipants(final int exactValue) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("Participants")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Participants", exactValue));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByParticipants(final int lowerbound, final int higherbound) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("*")));
			final String where = " WHERE Activity.Participants > ? AND Activity.Participants < ?";
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues) + where;
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Participants", lowerbound), new Pair<>("Participants", higherbound));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByPrice(final ActivityMapper sampleActivity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("Price")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Price", sampleActivity.getPrice()));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByPrice(final double exactValue) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("Price")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Price", exactValue));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByPrice(final double lowerbound, final double higherbound) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("*")));
			final String where = " WHERE Activity.Price > ? AND Activity.Price < ?";
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues) + where;
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Price", lowerbound), new Pair<>("Price", higherbound));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByType(final ActivityTypeMapper activityType) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("ActivityTypeId")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("ActivityTypeId", activityType.getId()));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByType(final int activityTypeId) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("ActivityTypeId")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("ActivityTypeId", activityTypeId));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityMapper> readActivitiesByType(final String activityTypeName) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final String join = " JOIN  ActivityType ON Activity.ActivityTypeId = ActivityType.Id";
			final String where = " WHERE ActivityType.Name = ?";
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues) + join + where;
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("ActivityType.Name", activityTypeName));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final ActivityMapper readActivityById(final int id) throws EntityNotUniqueException {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("Id")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Id", id));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			if(activities.size() == 1) {
				return activities.get(0);
			}
			throw new EntityNotUniqueException();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final ActivityMapper readActivityByKey(final int key) throws EntityNotUniqueException {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("ActivityKey")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("ActivityKey", key));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			if(activities.size() == 1) {
				return activities.get(0);
			}
			throw new EntityNotUniqueException();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final ActivityMapper readActivityByName(final String name) throws EntityNotUniqueException {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(new Pair<>("Activity", Arrays.asList("Name")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Name", name));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			if(activities.size() == 1) {
				return activities.get(0);
			}
			throw new EntityNotUniqueException();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final ActivityTypeMapper readActivityTypeById(final int id) throws EntityNotUniqueException {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(new Pair<>("ActivityType", Arrays.asList("*")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(new Pair<>("ActivityType", Arrays.asList("Id")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Id", id));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityTypeMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityTypeMapper(set));
			}
			if(activities.size() == 1) {
				return activities.get(0);
			}
			throw new EntityNotUniqueException();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final ActivityTypeMapper readActivityTypeByName(final String name) throws EntityNotUniqueException {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(new Pair<>("ActivityType", Arrays.asList("Id", "Name")));
			final List<Pair<String, List<String>>> whereValues = Arrays.asList(new Pair<>("ActivityType", Arrays.asList("Name")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues, whereValues);
			final List<Pair<String, Object>> params = Arrays.asList(new Pair<>("Name", name));
			ResultSet set = db.executeQuery(sql, params);
			
			List<ActivityTypeMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityTypeMapper(set));
			}
			if(activities.size() == 1) {
				return activities.get(0);
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

	public final List<ActivityMapper> readAllActivities() {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("Activity", Arrays.asList("*")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues);
			ResultSet set = db.executeQuery(sql);
			
			List<ActivityMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final List<ActivityTypeMapper> readAllActivityTypes() {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			final List<Pair<String, List<String>>> readValues = Arrays.asList(
					new Pair<>("ActivityType", Arrays.asList("*")));
			final String sql = MySqlQueryBuilder.buildSelectQuery(readValues);
			ResultSet set = db.executeQuery(sql);
			
			List<ActivityTypeMapper> activities = new ArrayList<>();
			while(set.next()) {
				activities.add(new ActivityTypeMapper(set));
			}
			return activities;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final void updateActivity(final ActivityMapper activity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			ActivityMapper oldActivity = this.readActivityByKey(activity.getActivityKey());
			List<String> diff = new ArrayList<>();
			final List<Pair<String, Object>> params = new ArrayList<>();
			if(activity.getAccessibility() != oldActivity.getAccessibility()) {
				diff.add("Accessibility");
				params.add(new Pair<>("Accessibility", activity.getAccessibility()));
			}
			if(activity.getActivityTypeId() != oldActivity.getActivityTypeId()) {
				diff.add("ActivityKey");
				params.add(new Pair<>("ActivityTypeId", activity.getActivityTypeId()));
			}
			if(activity.getLink().contentEquals(oldActivity.getLink())) {
				diff.add("Link");
				params.add(new Pair<>("Link", activity.getLink()));
			}
			if(activity.getName().contentEquals(oldActivity.getName())) {
				diff.add("Name");
				params.add(new Pair<>("Name", activity.getName()));
			}
			if(activity.getParticipants() != oldActivity.getParticipants()) {
				diff.add("Participants");
				params.add(new Pair<>("Participants", activity.getParticipants()));
			}
			if(activity.getPrice() != oldActivity.getPrice()) {
				diff.add("Price");
				params.add(new Pair<>("Price", activity.getPrice()));
			}
			final Pair<String, List<String>> updateValues = new Pair<>("Activity", diff);
			final List<String> columns = Arrays.asList("ActivityKey");
			final String sql = MySqlQueryBuilder.buildUpdateQuery(updateValues, columns);
			db.execute(sql, params);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotUniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void updateActivityById(final int id, final ActivityMapper activity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			ActivityMapper oldActivity = this.readActivityByKey(activity.getActivityKey());
			List<String> diff = new ArrayList<>();
			final List<Pair<String, Object>> params = new ArrayList<>();
			if(activity.getAccessibility() != oldActivity.getAccessibility()) {
				diff.add("Accessibility");
				params.add(new Pair<>("Accessibility", activity.getAccessibility()));
			}
			if(activity.getActivityTypeId() != oldActivity.getActivityTypeId()) {
				diff.add("ActivityKey");
				params.add(new Pair<>("ActivityTypeId", activity.getActivityTypeId()));
			}
			if(activity.getLink().contentEquals(oldActivity.getLink())) {
				diff.add("Link");
				params.add(new Pair<>("Link", activity.getLink()));
			}
			if(activity.getName().contentEquals(oldActivity.getName())) {
				diff.add("Name");
				params.add(new Pair<>("Name", activity.getName()));
			}
			if(activity.getParticipants() != oldActivity.getParticipants()) {
				diff.add("Participants");
				params.add(new Pair<>("Participants", activity.getParticipants()));
			}
			if(activity.getPrice() != oldActivity.getPrice()) {
				diff.add("Price");
				params.add(new Pair<>("Price", activity.getPrice()));
			}
			final Pair<String, List<String>> updateValues = new Pair<>("Activity", diff);
			final List<String> columns = Arrays.asList("Id");
			final String sql = MySqlQueryBuilder.buildUpdateQuery(updateValues, columns);
			db.execute(sql, params);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotUniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void updateActivityByKey(final int key, final ActivityMapper activity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			ActivityMapper oldActivity = this.readActivityByKey(activity.getActivityKey());
			List<String> diff = new ArrayList<>();
			final List<Pair<String, Object>> params = new ArrayList<>();
			if(activity.getAccessibility() != oldActivity.getAccessibility()) {
				diff.add("Accessibility");
				params.add(new Pair<>("Accessibility", activity.getAccessibility()));
			}
			if(activity.getActivityTypeId() != oldActivity.getActivityTypeId()) {
				diff.add("ActivityKey");
				params.add(new Pair<>("ActivityTypeId", activity.getActivityTypeId()));
			}
			if(activity.getLink().contentEquals(oldActivity.getLink())) {
				diff.add("Link");
				params.add(new Pair<>("Link", activity.getLink()));
			}
			if(activity.getName().contentEquals(oldActivity.getName())) {
				diff.add("Name");
				params.add(new Pair<>("Name", activity.getName()));
			}
			if(activity.getParticipants() != oldActivity.getParticipants()) {
				diff.add("Participants");
				params.add(new Pair<>("Participants", activity.getParticipants()));
			}
			if(activity.getPrice() != oldActivity.getPrice()) {
				diff.add("Price");
				params.add(new Pair<>("Price", activity.getPrice()));
			}
			final Pair<String, List<String>> updateValues = new Pair<>("Activity", diff);
			final List<String> columns = Arrays.asList("ActivityKey");
			final String sql = MySqlQueryBuilder.buildUpdateQuery(updateValues, columns);
			db.execute(sql, params);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotUniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void updateActivityByName(final String name, final ActivityMapper activity) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			ActivityMapper oldActivity = this.readActivityByKey(activity.getActivityKey());
			List<String> diff = new ArrayList<>();
			final List<Pair<String, Object>> params = new ArrayList<>();
			if(activity.getAccessibility() != oldActivity.getAccessibility()) {
				diff.add("Accessibility");
				params.add(new Pair<>("Accessibility", activity.getAccessibility()));
			}
			if(activity.getActivityTypeId() != oldActivity.getActivityTypeId()) {
				diff.add("ActivityKey");
				params.add(new Pair<>("ActivityTypeId", activity.getActivityTypeId()));
			}
			if(activity.getLink().contentEquals(oldActivity.getLink())) {
				diff.add("Link");
				params.add(new Pair<>("Link", activity.getLink()));
			}
			if(activity.getName().contentEquals(oldActivity.getName())) {
				diff.add("Name");
				params.add(new Pair<>("Name", activity.getName()));
			}
			if(activity.getParticipants() != oldActivity.getParticipants()) {
				diff.add("Participants");
				params.add(new Pair<>("Participants", activity.getParticipants()));
			}
			if(activity.getPrice() != oldActivity.getPrice()) {
				diff.add("Price");
				params.add(new Pair<>("Price", activity.getPrice()));
			}
			final Pair<String, List<String>> updateValues = new Pair<>("Activity", diff);
			final List<String> columns = Arrays.asList("ActivityKey");
			final String sql = MySqlQueryBuilder.buildUpdateQuery(updateValues, columns);
			params.add(new Pair<>("Name", name));
			db.execute(sql, params);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotUniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void updateActivityType(final ActivityTypeMapper activityType) {
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(dbVersion)) {
			ActivityTypeMapper oldActivityType = this.readActivityTypeById(activityType.getId());
			List<String> diff = new ArrayList<>();
			final List<Pair<String, Object>> params = new ArrayList<>();
			if(!activityType.getName().contentEquals(oldActivityType.getName())) {
				diff.add("Name");
				params.add(new Pair<>("Name", activityType.getName()));
			}
			final Pair<String, List<String>> updateValues = new Pair<>("Activity", diff);
			final List<String> columns = Arrays.asList("ActivityKey");
			final String sql = MySqlQueryBuilder.buildUpdateQuery(updateValues, columns);
			params.add(new Pair<>("Id", activityType.getId()));
			db.execute(sql, params);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotUniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final void updateActivityTypeById(final int id, final ActivityTypeMapper activityType) {
		// TODO Implement query execution.
	}
}
