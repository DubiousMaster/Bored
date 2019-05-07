package main.core.models;

public final class Activity extends Entity {
	private double accessibility;
	private int activityKey;
	private String activityType;
	private String link;
	private String name;
	private int participants;
	private double price;

	public Activity(final String name, final double accessibility, final String activityType, final int participants,
			final double price, final String link, final int activityKey) {
		super();
		this.setName(name);
		this.setAccessibility(accessibility);
		this.setActivityType(activityType);
		this.setParticipants(participants);
		this.setPrice(price);
		this.setLink(link);
		this.setActivityKey(activityKey);
	}

	public double getAccessibility() {
		return this.accessibility;
	}

	public int getActivityKey() {
		return this.activityKey;
	}

	public String getActivityType() {
		return this.activityType;
	}

	public String getLink() {
		return this.link;
	}

	public String getName() {
		return this.name;
	}

	public int getParticipants() {
		return this.participants;
	}

	public double getPrice() {
		return this.price;
	}

	private void setAccessibility(final double value) {
		this.accessibility = value;
	}

	private void setActivityKey(final int value) {
		this.activityKey = value;
	}

	private void setActivityType(final String value) {
		this.activityType = value;
	}

	private void setLink(final String value) {
		this.link = value;
	}

	private void setName(final String value) {
		this.name = value;
	}

	private void setParticipants(final int value) {
		this.participants = value;
	}

	private void setPrice(final double value) {
		this.price = value;
	}

}
