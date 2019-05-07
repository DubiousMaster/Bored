package main.core.models;

public final class ActivityType extends Entity {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ActivityType(String name) {
		super();
		this.setName(name);
	}
}
