package main.core.models;

public class ActivityType {
	private int id;
	private String name;
	
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public void setName(String value) { this.name = value; }

	public ActivityType(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
