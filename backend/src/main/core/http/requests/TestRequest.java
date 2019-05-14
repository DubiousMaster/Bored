package main.core.http.requests;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import main.core.database.Database;
import main.core.database.mysql.managers.MySqlDatabase;
import main.core.database.mysql.managers.MySqlDatabaseFactory;
import main.core.database.mysql.managers.MySqlDatabaseVersions;

/**
 * A small section dedicated to testing connections, requests and responses.
 *
 * @author Alex Tigchelaar
 *
 */
@Path("/test")
public class TestRequest extends Request {
	@GET
	@Path("/connection")
	public Response testConnection() {
		System.out.println("Database Connection test succeeded.");
		try (Database db = MySqlDatabaseFactory.createMySqlDatabase(MySqlDatabaseVersions.MySqlDatabase)) {
			db.execute("");
			return Response.accepted().build();
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(Status.SERVICE_UNAVAILABLE).build();
	}

	/**
	 * If a connection can be established, return 202 Accepted.
	 *
	 * @return Returns an accepted response.
	 */
	@GET
	public Response testGet() {
		System.out.println("Simple GET test succeeded.");
		return Response.accepted().build();
	}

	/**
	 * If a connection can be established, return 202 Accepted with some additional
	 * data.
	 *
	 * @return Returns an accepted response with a JSON string.
	 */
	@GET
	@Produces("application/json")
	@Path("/advanced")
	public Response testGetAdvanced() {
		System.out.println("Advanced GET test succeeded.");
		return Response.accepted().entity("\"Can I put anything \\\" in here?\"").build();
	}

	/**
	 * If JSON objects can be received, return 202 Accepted.
	 *
	 * @param testStrings A JSON object containing a bunch of strings.
	 * @return Returns an accepted response.
	 */
	@POST
	@Consumes("application/json")
	public Response testPost(final String[] testStrings) {
		System.out.println("Simple POST test succeeded.");
		for (final String test : testStrings) {
			System.out.println(test);
		}
		return Response.accepted().build();
	}
}
