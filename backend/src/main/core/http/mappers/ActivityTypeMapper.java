package main.core.http.mappers;

import main.models.ActivityType;

/**
 * Map data from http connections to activity types.
 * 
 * @author Alex Tigchelaar
 *
 */
public final class ActivityTypeMapper extends Mapper {
	private String name;

	public ActivityTypeMapper() {
		super();
	}

	public ActivityTypeMapper(final String name) {
		this.name = name;
	}

	public final String getName() {
		return this.name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * Convert the activity type mapper to an actual activity type.
	 */
	@Override
	public ActivityType toEntity() {
		return new ActivityType(this.name);
	}
}
