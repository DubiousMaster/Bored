package main.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class FirstRequest {
	@GET
	public Response testMethod() {
		return Response.accepted().build();
	}
}
