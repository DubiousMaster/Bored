package main.core.http.mappers;

import main.models.Activity;

public final class ActivityMapper extends Mapper {
	private double accessibility;
	private int activityKey;
	private String activityType;
	private String link;
	private String name;
	private int participants;
	private double price;

	public ActivityMapper() {
		super();
	}

	public ActivityMapper(final String name, final double accessibility, final String activityType,
			final int participants, final double price, final String link, final int activityKey) {
		this.name = name;
		this.accessibility = accessibility;
		this.activityType = activityType;
		this.participants = participants;
		this.price = price;
		this.link = link;
		this.activityKey = activityKey;
	}

	public final double getAccessibility() {
		return this.accessibility;
	}

	public final int getActivityKey() {
		return this.activityKey;
	}

	public final String getActivityType() {
		return this.activityType;
	}

	public final String getLink() {
		return this.link;
	}

	public final String getName() {
		return this.name;
	}

	public final int getParticipants() {
		return this.participants;
	}

	public final double getPrice() {
		return this.price;
	}

	public final void setAccessibility(final double accessibility) {
		this.accessibility = accessibility;
	}

	public final void setActivityKey(final int activityKey) {
		this.activityKey = activityKey;
	}

	public final void setActivityType(final String activityType) {
		this.activityType = activityType;
	}

	public final void setLink(final String link) {
		this.link = link;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final void setParticipants(final int participants) {
		this.participants = participants;
	}

	public final void setPrice(final double price) {
		this.price = price;
	}

	/**
	 * Convert the activity mapper to an actual activity.
	 */
	@Override
	public Activity toEntity() {
		return new Activity(this.name, this.accessibility, this.activityType, this.participants, this.price, this.link,
				this.activityKey);
	}
}
