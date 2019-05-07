package main.core.db.mysql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.core.models.Activity;
import main.core.models.ActivityType;
import main.core.models.Entity;

public class ActivityTypeMapper extends Mapper {
	private int id;
	private String name;

	public ActivityTypeMapper() {
		super();
	}

	public ActivityTypeMapper(final Activity activity) {
		this();
		this.setName(activity.getActivityType());
	}

	public ActivityTypeMapper(final int id, final String name) {
		this();
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public ActivityTypeMapper fillMapper(ResultSet set) throws SQLException {
		this.setId(set.getInt("Id"));
		this.setName(set.getString("Name"));
		
		return this;
	}

	@Override
	public ActivityType toEntity() {
		return new ActivityType(this.getName());
	}
}
