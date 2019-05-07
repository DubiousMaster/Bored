package main.core.http;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import main.core.db.DataRepository;
import main.core.db.mysql.MySqlRepository;
import main.core.models.Activity;

/**
 * Handle all activity related requests
 * @author Alex Tigchelaar
 *
 */
@Path("/activities")
public class ActivityRequest extends Request {
	
	DataRepository repository = new MySqlRepository();
	
	@GET
	@Produces("application/json")
	public Response getAllActivities() {
		List<Activity> activities = repository.readAllActivities();
		
		// TODO: Change entity object.
		return Response.status(Status.ACCEPTED).entity(activities).build();
	}
	
	@GET
	@Path("/key/{activityKey}")
	public Response getActivityByKey(@PathParam("activityKey") int key) {
		Activity activity = repository.readActivityByKey(key);

		return Response.status(Status.ACCEPTED).entity(activity).build();
	}
}
