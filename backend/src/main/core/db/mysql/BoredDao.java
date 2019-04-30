package main.core.db.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.core.models.Activity;

public class BoredDao {

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
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				connector.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return activity;
	}
}
