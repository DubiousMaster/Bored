package main.core.db.mysql.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.core.db.Database;
import main.core.db.mysql.MySqlDatabase;
import main.core.db.mysql.MySqlQueryBuilder;
import main.core.models.Activity;

public class ActivityDao extends Dao {

	public Activity getActivityById(final int id) {
		if (id < 0)
			throw new IllegalArgumentException("An id must be a positive number.");
		Activity activity = null;
		try (Database db = new MySqlDatabase()) {
			final String sql = MySqlQueryBuilder.buildSelectQuery(new String[] { "*" }, new String[] { "Activity" },
					new String[] { "Id" });

			final Object[] params = new Object[] { id };
			final ResultSet set = db.executeQuery(sql, params);

			while (set.next()) {
				final int activityId = set.getInt("Id");
				final String activityName = set.getString("Name");
				final double accessibility = set.getDouble("Accessibility");
				final int type = set.getInt("Type");
				final int participants = set.getInt("Participants");
				final double price = set.getDouble("Price");
				final String link = set.getString("Link");
				final int activityKey = set.getInt("ActivityKey");
				activity = new Activity(activityId, activityName, accessibility, type, participants, price, link,
						activityKey);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return activity;
	}

	public Activity getActivityByKey(final int key) {
		if (key < 0 || key > 9999999)
			throw new IllegalArgumentException("A key has a value between 0 and 9999999.");
		Activity activity = null;
		try (Database db = new MySqlDatabase()) {
			final String sql = MySqlQueryBuilder.buildSelectQuery(new String[] { "*" }, new String[] { "Activity" },
					new String[] { "ActivityKey" });

			final Object[] params = new Object[] { key };
			final ResultSet set = db.executeQuery(sql, params);

			while (set.next()) {
				final int activityId = set.getInt("Id");
				final String activityName = set.getString("Name");
				final double accessibility = set.getDouble("Accessibility");
				final int type = set.getInt("Type");
				final int participants = set.getInt("Participants");
				final double price = set.getDouble("Price");
				final String link = set.getString("Link");
				final int activityKey = set.getInt("ActivityKey");
				activity = new Activity(activityId, activityName, accessibility, type, participants, price, link,
						activityKey);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return activity;
	}

	public List<Activity> getAllActivities() {
		final List<Activity> activities = new ArrayList<>();
		try (Database db = new MySqlDatabase()) {
			final String sql = MySqlQueryBuilder.buildSelectQuery(new String[] { "*" }, new String[] { "Activity" });

			final ResultSet set = db.executeQuery(sql);

			while (set.next()) {
				final int activityId = set.getInt("Id");
				final String activityName = set.getString("Name");
				final double accessibility = set.getDouble("Accessibility");
				final int type = set.getInt("Type");
				final int participants = set.getInt("Participants");
				final double price = set.getDouble("Price");
				final String link = set.getString("Link");
				final int activityKey = set.getInt("ActivityKey");
				activities.add(new Activity(activityId, activityName, accessibility, type, participants, price, link,
						activityKey));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return activities;
	}
}
