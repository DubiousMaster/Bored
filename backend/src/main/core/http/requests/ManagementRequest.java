package main.core.http.requests;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import main.core.http.mappers.ActivityMapper;
import main.core.http.mappers.ActivityTypeMapper;

/**
 * Requests only accessible to management.
 * 
 * @author Alex Tigchelaar
 *
 */
@Path("/management")
public class ManagementRequest extends Request {
	/**
	 * Delete an activity from the database.
	 * 
	 * @param activityMapper The activity data.
	 * @return Returns accepted if the request succeeded. Returns an error if the
	 *         request failed.
	 */
	@DELETE
	@Path("/activities/delete")
	@Consumes("application/json")
	public Response deleteActivity(final ActivityMapper activityMapper) {
		System.out.println("Request received. Deleting the received activity.");
		try {
			// TODO Delete an existing activity type.
			return Response.status(Status.NO_CONTENT).build();
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
	}

	/**
	 * Delete an activity type from the database.
	 * 
	 * @param activityMapper The activity type data.
	 * @return Returns accepted if the request succeeded. Returns an error if the
	 *         request failed.
	 */
	@DELETE
	@Path("/activities/types/delete")
	@Consumes("application/json")
	public Response deleteActivityType(final ActivityTypeMapper activityTypeMapper) {
		System.out.println("Request received. Deleting the received activity type.");
		try {
			// TODO Delete an existing activity type.
			return Response.status(Status.NO_CONTENT).build();
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
	}
}
