package main.core.http;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import main.core.db.mysql.ActivityDao;
import main.core.models.Activity;

/**
 * Handle all activity related requests
 * @author Alex Tigchelaar
 *
 */
@Path("/activities")
public class ActivityRequest extends Request {
	
	/**
	 * Instantiate the database access object used to collect activity data.
	 */
	private ActivityDao dao = new ActivityDao();
	
	@GET
	public Response getAllActivities() {
		List<Activity> activities = dao.getAllActivities();
		
		// TODO: Change entity object.
		return Response.status(Status.ACCEPTED).entity(activities).build();
	}
	
	@GET
	@Path("/id/{0}")
	public Response getActivityById(@PathParam("activityId") int id) {
		Activity activity = dao.getActivity(id);
		
		return Response.status(Status.ACCEPTED).entity(activity).build();
	}
	
	@GET
	@Path("/key/{0}")
	public Response getActivityByKey(@PathParam("activityKey") int key) {
		Activity activity = dao.getActivity(key);
		
		return Response.status(Status.ACCEPTED).entity(activity).build();
	}
}
