package main.core.database.mysql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.core.database.mysql.MySqlRepository;
import main.core.database.mysql.dao.BoredDao;
import main.core.exceptions.EntityNotUniqueException;
import main.models.Activity;
import main.models.ActivityType;

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

	public ActivityMapper(final int id, final String name, final double accessibility, final int activityTypeId,
			final int participants, final double price, final String link, final int activityKey) {
		this();
		this.id = id;
		this.name = name;
		this.accessibility = accessibility;
		this.activityTypeId = activityTypeId;
		this.participants = participants;
		this.price = price;
		this.link = link;
		this.activityKey = activityKey;
	}
	
	public ActivityMapper(Activity activity) {
		this.name = activity.getName();
		this.accessibility = activity.getAccessibility();
		try {
			ActivityTypeMapper activityType = new BoredDao().readActivityTypeByName(activity.getActivityType());
			if(activityType != null) {
				this.activityTypeId = activityType.getId();
			}
		} catch (EntityNotUniqueException e) {
			e.printStackTrace();
		}
		this.participants = activity.getParticipants();
		this.price = activity.getPrice();
		this.link = activity.getLink();
		this.activityKey = activity.getActivityKey();
	}
	
	public ActivityMapper(ResultSet set) {
		this();
		try {
			this.setId(set.getInt("Id"));
			this.setName(set.getString("Name"));
			this.setAccessibility(set.getDouble("Accessibility"));
			this.setActivityTypeId(set.getInt("ActivityTypeId"));
			this.setParticipants(set.getInt("Participants"));
			this.setPrice(set.getDouble("Price"));
			this.setLink(set.getString("Link"));
			this.setActivityKey(set.getInt("ActivityKey"));
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final double getAccessibility() {
		return this.accessibility;
	}

	public final int getActivityKey() {
		return this.activityKey;
	}

	public final int getActivityTypeId() {
		return this.activityTypeId;
	}

	public final int getId() {
		return this.id;
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

	public final void setActivityTypeId(final int activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	public final void setId(final int id) {
		this.id = id;
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

	@Override
	public Activity toEntity() {
		ActivityType activityType;
		try {
			activityType = ((MySqlRepository) getRepository()).readActivityTypeById(this.getActivityTypeId());
			return new Activity(this.name, this.accessibility, activityType.getName(), this.participants, this.price,
					this.link, this.activityKey);
		} catch (EntityNotUniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Activity(this.name, this.accessibility, "N/A", this.participants, this.price, this.link, this.activityKey);
	}
}
