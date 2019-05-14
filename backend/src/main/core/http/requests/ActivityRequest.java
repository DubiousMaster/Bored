package main.core.http.requests;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import main.core.database.DBTypes;
import main.core.database.DataRepository;
import main.core.database.RepositoryFactory;
import main.core.exceptions.EntityNotUniqueException;
import main.core.http.mappers.ActivityMapper;
import main.core.http.mappers.ActivityTypeMapper;
import main.models.Activity;
import main.models.ActivityType;

/**
 * Manage all activity related requests.
 *
 * @author Alex Tigchelaar
 *
 */
@Path("/activities")
public class ActivityRequest extends Request {
	
	private DataRepository repository = RepositoryFactory.createRepository(DBTypes.MY_SQL);
	
	/**
	 * Get all activities in a list.
	 *
	 * @return Returns a list of all activities.
	 */
	@GET
	public Response getActivities() {
		System.out.println("Request received. Collecting all activities.");
		List<Activity> activities = repository.readAllActivities();
		if(activities == null) activities = new ArrayList<>();
		return Response.accepted().entity(activities).build();
	}

	/**
	 * Get all activities between the given boundaries.
	 *
	 * @param firstBound  The first boundary, often the lowest.
	 * @param secondBound The second boundary, often the highest.
	 * @return Returns a list of all activities with an accessibility between these
	 *         two boundaries.
	 */
	@GET
	@Path("/accessibility/{firstBound}/{secondBound}")
	public Response getActivitiesByAccessibility(@PathParam("firstBound") final String firstBound,
			@PathParam("secondBound") final String secondBound) {
		System.out.println("Request received. Collecting all activities with the given accessibility boundaries.");
		try {
			double firstDouble = Double.parseDouble(firstBound);
			double secondDouble = Double.parseDouble(secondBound);
			double lowerbound;
			double higherbound;
			if((firstDouble < 0) || (secondDouble < 0) || (firstDouble > 1) || (secondDouble > 1)) throw new IllegalArgumentException("The accessibility is measured between 0.00 and 1.00.");
			if(firstDouble < secondDouble) {
				lowerbound = firstDouble;
				higherbound = secondDouble;
			} else {
				lowerbound = secondDouble;
				higherbound = firstDouble;
			}
			List<Activity> activities = repository.readAllActivitiesByAccessibility(lowerbound, higherbound);
			if(activities == null) activities = new ArrayList<>();
			return Response.accepted().entity(activities).build();
		} catch(NumberFormatException e) {
			// TODO Return response when converting the received values fails.
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	/**
	 * Get the activity with the given key.
	 *
	 * @param activityKey The unique key to collect one specific activity.
	 * @return Returns a single activity.
	 */
	@GET
	@Path("/key/{activityKey}")
	public Response getActivityByKey(@PathParam("activityKey") final String activityKey) {
		System.out.println("Request received. Collecting the activity with the given key.");
		try {
			int key = Integer.parseInt(activityKey);
			Activity activity = repository.readActivityByKey(key);
			return Response.accepted().entity(activity).build();
		} catch(NumberFormatException e) {
			// TODO Return response when converting the received value fails.
		} catch (EntityNotUniqueException e) {
			return Response.status(Status.CONFLICT).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	/**
	 * Get all activities with the provided name.
	 *
	 * @param name The name of the activities.
	 * @return Returns a list of activities.
	 */
	@GET
	@Path("/name/{activityName}")
	public Response getActivityByName(@PathParam("activityName") final String activityName) {
		System.out.println("Request received. Collecting all activities with the given name.");
		Activity activity;
		try {
			activity = repository.readActivityByName(activityName);
		} catch (EntityNotUniqueException e) {
			return Response.status(Status.CONFLICT).build();
		}
		return Response.accepted().entity(activity).build();
//		return Response.status(Status.BAD_REQUEST).build();
	}

	/**
	 * Get all activities between the given boundaries.
	 *
	 * @param firstBound  The first boundary, often the lowest.
	 * @param secondBound The second boundary, often the highest.
	 * @return Returns a list of all activities with an amount of participants
	 *         between these two boundaries.
	 */
	@GET
	@Path("/participants/{firstBound}/{secondBound}")
	public Response getActivitiesByParticipants(@PathParam("firstBound") final String firstBound,
			@PathParam("secondBound") final String secondBound) {
		System.out.println("Request received. Collecting all activities with the given participant boundaries.");
		try {
			int firstInt = Integer.parseInt(firstBound);
			int secondInt = Integer.parseInt(secondBound);
			int lowerbound;
			int higherbound;
			if((firstInt < 0) || (secondInt < 0)) throw new IllegalArgumentException("Cannot have less than no participants.");
			if(firstInt < secondInt) {
				lowerbound = firstInt;
				higherbound = secondInt;
			} else {
				lowerbound = secondInt;
				higherbound = firstInt;
			}
			List<Activity> activities = repository.readAllActivitiesByParticipants(lowerbound, higherbound);
			if(activities == null) activities = new ArrayList<>();
			return Response.accepted().entity(activities).build();
		} catch(NumberFormatException e) {
			// TODO Return response when converting the received values fails.
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	/**
	 * Get all activities between the given boundaries.
	 *
	 * @param firstBound   The first boundary, often the lowest.
	 * @param secoundBound The second boundary, often the highest.
	 * @return Returns a list of all activities with a price between these two
	 *         boundaries.
	 */
	@GET
	@Path("/price/{firstBound}/{secondBound}")
	public Response getActivitiesByPrice(@PathParam("firstBound") final String firstBound,
			@PathParam("secondBound") final String secondBound) {
		System.out.println("Request received. Collecting all activities with the given price boundaries.");
		try {
			double firstDouble = Double.parseDouble(firstBound);
			double secondDouble = Double.parseDouble(secondBound);
			double lowerbound;
			double higherbound;
			if((firstDouble < 0) || (secondDouble < 0)) throw new IllegalArgumentException("The price cannot be less than 0.");
			if(firstDouble < secondDouble) {
				lowerbound = firstDouble;
				higherbound = secondDouble;
			} else {
				lowerbound = secondDouble;
				higherbound = firstDouble;
			}
			List<Activity> activities = repository.readAllActivitiesByPrice(lowerbound, higherbound);
			if(activities == null) activities = new ArrayList<>();
			return Response.accepted().entity(activities).build();
		} catch(NumberFormatException e) {
			// TODO Return response when converting the received values fails.
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	/**
	 * Get all activity types.
	 *
	 * @return Returns a list of all activity types.
	 */
	@GET
	@Path("/types")
	public Response getActivityTypes() {
		System.out.println("Request received. Collecting all activity types.");
		List<ActivityType> activityTypes = repository.readAllActivityTypes();
		if(activityTypes == null) activityTypes = new ArrayList<>();
		return Response.accepted().entity(activityTypes).build();
//		return Response.status(Status.NO_CONTENT).build();
	}

	/**
	 * Create a new activity.
	 *
	 * @param activityMapper Activity data.
	 * @return Returns accepted if the request succeeded. Returns an error if the
	 *         request failed.
	 */
	@POST
	@Path("/new")
	@Consumes("application/json")
	public Response postNewActivity(final ActivityMapper activityMapper) {
		System.out.println("Request received. Creating a new activity.");
		try {
			repository.storeActivity(activityMapper.toEntity());
			return Response.accepted().build();
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
	}

	/**
	 * Create a new activity type.
	 *
	 * @param activityTypeMapper Activity type data.
	 * @return Returns accepted if the request succeeded. Returns an error if the
	 *         request failed.
	 */
	@POST
	@Path("/types/new")
	@Consumes("application/json")
	public Response postNewActivityType(final ActivityTypeMapper activityTypeMapper) {
		System.out.println("Request received. Creating a new activity type.");
		try {
			repository.storeActivityType(activityTypeMapper.toEntity());
			return Response.accepted().build();
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
	}

	/**
	 * Update an existing activity.
	 *
	 * @param activityMapper Activity data.
	 * @return Returns accepted if the request succeeded. Returns an error if the
	 *         request failed.
	 */
	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response postUpdateActivity(final ActivityMapper activityMapper) {
		System.out.println("Request received. Updating the received activity.");
		try {
			repository.updateActivity(activityMapper.toEntity());
			return Response.accepted().build();
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
	}

	/**
	 * Update an existing activity type.
	 *
	 * @param activityTypeMapper Activity type data.
	 * @return Returns accepted if the request succeeded. Returns an error if the
	 *         request failed.
	 */
	@POST
	@Path("/types/update")
	@Consumes("application/json")
	public Response postUpdateActivityType(final ActivityTypeMapper activityTypeMapper) {
		System.out.println("Request received. Updating the received activity type.");
		try {
			repository.updateActivityType(activityTypeMapper.toEntity());
			return Response.accepted().build();
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
	}
}
