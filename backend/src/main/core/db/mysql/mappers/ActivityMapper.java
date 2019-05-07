package main.core.db.mysql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.core.db.mysql.MySqlRepository;
import main.core.models.Activity;
import main.core.models.ActivityType;
import main.core.models.Entity;

public class ActivityMapper extends Mapper {
	private double accessibility;
	private int activityKey;
	private int activityTypeId;
	private int id;
	private String link;
	private String name;
	private int participants;
	private double price;

	public ActivityMapper() {
		super();
	}

	public ActivityMapper(final Activity activity) {
		this();
		this.setName(activity.getName());
		this.setAccessibility(activity.getAccessibility());
		this.setParticipants(activity.getParticipants());
		this.setPrice(activity.getPrice());
		this.setLink(activity.getLink());
		this.setActivityKey(activity.getActivityKey());
	}

	public ActivityMapper(final int id, final String name, final double accessibility, final int activityTypeId,
			final int participants, final double price, final String link, final int activityKey) {
		this();
		this.setId(id);
		this.setName(name);
		this.setAccessibility(accessibility);
		this.setActivityTypeId(activityTypeId);
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

	public int getActivityTypeId() {
		return this.activityTypeId;
	}

	public int getId() {
		return this.id;
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

	public void setAccessibility(final double accessibility) {
		this.accessibility = accessibility;
	}

	public void setActivityKey(final int activityKey) {
		this.activityKey = activityKey;
	}

	public void setActivityTypeId(final int activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setLink(final String link) {
		this.link = link;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setParticipants(final int participants) {
		this.participants = participants;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	@Override
	public ActivityMapper fillMapper(ResultSet set) throws SQLException {
		this.setAccessibility(set.getDouble("Accessibility"));
		this.setActivityKey(set.getInt("ActivityKey"));
		this.setActivityTypeId(set.getInt("ActivityTypeId"));
		this.setId(set.getInt("Id"));
		this.setLink(set.getString("Link"));
		this.setName(set.getString("Name"));
		this.setParticipants(set.getInt("Participants"));
		this.setPrice(set.getDouble("Price"));

		return this;
	}

	@Override
	public Activity toEntity() {
		ActivityType activityType = new MySqlRepository().readActivityTypeById(this.getActivityTypeId());
		return new Activity(this.getName(), this.getAccessibility(), activityType.getName(), this.getParticipants(),
				this.getPrice(), this.getLink(), this.getActivityKey());
	}
}
