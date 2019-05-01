package main.core.db.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.core.models.Activity;

public class ActivityDao {

	public Activity getActivity(int id) {
		if(id < 0) throw new IllegalArgumentException("An id must be a positive number.");
		Activity activity = null;
		try {
			MySqlConnector connector = new MySqlConnector();
			
			try {
				String sql = "SELECT * FROM activity WHERE id = ?;";
				PreparedStatement statement = connector.connect().prepareStatement(sql);
				
				statement.setInt(1, id);
				
				ResultSet set = statement.executeQuery();
				System.out.println("Items collected: " + set.getFetchSize());
				
				while(set.next()) {
					int activityId = set.getInt("Id");
					String activityName = set.getString("Name");
					double accessibility = set.getDouble("Accessibility");
					int type = set.getInt("Type");
					int participants = set.getInt("Participants");
					double price = set.getDouble("Price");
					String link = set.getString("Link");
					int activityKey = set.getInt("ActivityKey");
					activity = new Activity(activityId, activityName, accessibility, type, participants, price, link, activityKey);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				connector.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return activity;
	}
	
	public Activity getActivityByKey(int key) {
		if(key < 0 || key > 99999) throw new IllegalArgumentException("A key has a value between 0 and 99999.");
		Activity activity = null;
		try {
			MySqlConnector connector = new MySqlConnector();
			
			try {
				String sql = "SELECT * FROM activity WHERE key = ?;";
				PreparedStatement statement = connector.connect().prepareStatement(sql);
				
				statement.setInt(1, key);
				
				ResultSet set = statement.executeQuery();
				System.out.println("Items collected: " + set.getFetchSize());
				
				while(set.next()) {
					int activityId = set.getInt("Id");
					String activityName = set.getString("Name");
					double accessibility = set.getDouble("Accessibility");
					int type = set.getInt("Type");
					int participants = set.getInt("Participants");
					double price = set.getDouble("Price");
					String link = set.getString("Link");
					int activityKey = set.getInt("ActivityKey");
					activity = new Activity(activityId, activityName, accessibility, type, participants, price, link, activityKey);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				connector.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return activity;
	}
	
	public List<Activity> getAllActivities() {
		List<Activity> activities = new ArrayList<>();
		try {
			MySqlConnector connector = new MySqlConnector();
			
			try {
				String sql = "SELECT * FROM activity;";
				PreparedStatement statement = connector.connect().prepareStatement(sql);
				
				ResultSet set = statement.executeQuery();
				System.out.println("Items collected: " + set.getFetchSize());
				
				while(set.next()) {
					int activityId = set.getInt("Id");
					String activityName = set.getString("Name");
					double accessibility = set.getDouble("Accessibility");
					int type = set.getInt("Type");
					int participants = set.getInt("Participants");
					double price = set.getDouble("Price");
					String link = set.getString("Link");
					int activityKey = set.getInt("ActivityKey");
					activities.add(new Activity(activityId, activityName, accessibility, type, participants, price, link, activityKey));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				connector.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return activities;
	}
	
	public void addUncheckedActivity(Activity activity) {
		try {
			System.out.println("Inserting " + activity.getName() + " into the database.");
			MySqlConnector connector = new MySqlConnector();
			
			try {
				String sql = "INSERT INTO activity "
						+ "(Name, Accessibility, Type, Participants, Price, Link, ActivityKey)"
						+ " VALUES "
						+ "(?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement statement = connector.connect().prepareStatement(sql);
				
				statement.setString(1, activity.getName());
				statement.setDouble(2, activity.getAccessibility());
				statement.setInt(3, activity.getType());
				statement.setInt(4, activity.getParticipants());
				statement.setDouble(5, activity.getPrice());
				statement.setString(6, activity.getLink());
				statement.setInt(7, activity.getActivityKey());
				
				statement.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				connector.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
