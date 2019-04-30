package main.core.models;

public class Activity {
	private int id;
	private String activity;
	private double accessibility;
	private int type;
	private int participants;
	private double price;
	private String link;
	private int activityKey;
	
	public int getId() { return this.id; }
	public String getActivity() { return this.activity; }
	public void setActivity(String value) { this.activity = value; }
	public double getAccessibility() { return this.accessibility; }
	public void setAccessibility(double value) { this.accessibility = value; }
	public int getType() { return this.type; }
	public void setType(int value) { this.type = value; }
	public int getParticipants() { return this.participants; }
	public void setParticipants(int value) { this.participants = value; }
	public double getPrice() { return this.price; }
	public void setPrice(double value) { this.price = value; }
	public String getLink() { return this.link; }
	public void setLink(String value) { this.link = value; }
	public int getActivityKey() { return this.activityKey; }
	public void setActivityKey(int value) { this.activityKey = value; }

	public Activity(
			int id,
			String activity,
			double accessibility,
			int type,
			int participants,
			double price,
			String link,
			int activityKey
		) {
		this.id = id;
		this.activity = activity;
		this.accessibility = accessibility;
		this.type = type;
		this.participants = participants;
		this.price = price;
		this.link = link;
		this.activityKey = activityKey;
	}

}
