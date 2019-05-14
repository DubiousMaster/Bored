package main.models;

/**
 * Define an activity.
 *
 * @author Alex Tigchelaar
 *
 */
public final class Activity extends Entity {
	/**
	 * A value between 0.00 and 1.00. The closer to 0.00 the value, the more
	 * accessible the activity is.
	 */
	private final double accessibility;
	/**
	 * A unique identifier for the activity.
	 */
	private final int activityKey;
	/**
	 * A general type of activity.
	 */
	private final String activityType;
	/**
	 * A link to a website with details or information on the activity.
	 */
	private final String link;
	/**
	 * The activity's name.
	 */
	private final String name;
	/**
	 * The amount of participants required for the activity.
	 */
	private final int participants;
	/**
	 * The price how much the activity would cost to do.
	 */
	private final double price;

	/**
	 * Initialize a new activity.
	 *
	 * @param name          The name belonging to the activity.
	 * @param accessibility How accessible is the activity to people.
	 * @param activityType  What type of activity this is.
	 * @param participants  The amount of people needed for the activity.
	 * @param price         How expensive the activity is.
	 * @param link          A url related to the activity.
	 * @param activityKey   The unique activity key.
	 */
	public Activity(final String name, final double accessibility, final String activityType, final int participants,
			final double price, final String link, final int activityKey) {
		super();
		this.name = name;
		this.accessibility = accessibility;
		this.activityType = activityType;
		this.participants = participants;
		this.price = price;
		this.link = link;
		this.activityKey = activityKey;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Activity other = (Activity) obj;
		if (this.activityKey != other.activityKey)
			return false;
		return true;
	}

	/**
	 * Get the accessibility level of the activity.
	 *
	 * @return Returns the accessibility level of the activity.
	 */
	public final double getAccessibility() {
		return this.accessibility;
	}

	/**
	 * Get the unique identifier of the activity.
	 *
	 * @return Returns the unique activity key.
	 */
	public final int getActivityKey() {
		return this.activityKey;
	}

	/**
	 * Get what kind of activity this is.
	 *
	 * @return Returns the type of the activity.
	 */
	public final String getActivityType() {
		return this.activityType;
	}

	/**
	 * Get a link to information about the activity.
	 *
	 * @return Returns a URL to the activity.
	 */
	public final String getLink() {
		return this.link;
	}

	/**
	 * Get the activity's name.
	 *
	 * @return Returns the name of the activity.
	 */
	public final String getName() {
		return this.name;
	}

	/**
	 * Get the amount of participants required for the activity.
	 *
	 * @return Returns the amount of people needed by the activity.
	 */
	public final int getParticipants() {
		return this.participants;
	}

	/**
	 * Get the expenses needed to perform the activity.
	 *
	 * @return Returns the price of the activity.
	 */
	public final double getPrice() {
		return this.price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.activityKey;
		return result;
	}

	@Override
	public String toString() {
		return "Activity [name=" + this.name + "]";
	}
}
