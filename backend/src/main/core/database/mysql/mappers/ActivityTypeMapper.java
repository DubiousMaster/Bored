package main.core.database.mysql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.models.ActivityType;

public class ActivityTypeMapper extends Mapper {
	private int id;
	private String name;

	public ActivityTypeMapper() {
		super();
	}

	public ActivityTypeMapper(final int id, final String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	public ActivityTypeMapper(final ActivityType activityType) {
		this();
		this.name = activityType.getName();
	}

	public ActivityTypeMapper(final ResultSet set) {
		this();
		try {
			this.setId(set.getInt("Id"));
			this.setName(set.getString("Name"));
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final int getId() {
		return this.id;
	}

	public final String getName() {
		return this.name;
	}

	public final void setId(final int id) {
		this.id = id;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	@Override
	public ActivityType toEntity() {
		return new ActivityType(this.name);
	}
}
