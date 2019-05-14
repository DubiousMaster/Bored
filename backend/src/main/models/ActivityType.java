package main.models;

/**
 * Define an activity type.
 * 
 * @author Alex Tigchelaar
 *
 */
public final class ActivityType extends Entity {
	/**
	 * The activity type's name.
	 */
	private final String name;

	/**
	 * Initialize a new activity type.
	 * 
	 * @param name The name belonging to the activity type.
	 */
	public ActivityType(final String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final ActivityType other = (ActivityType) obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Get the activity type's name.
	 * 
	 * @return Returns the name of the activity type.
	 */
	public final String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ActivityType [name=" + this.name + "]";
	}
}
