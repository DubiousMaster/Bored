package main.core.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import main.api.bored.DataFetch;

@Path("/fetch")
public class FetchRequest extends Request {

	@GET
	public Response fetchData() {
		DataFetch.fetchData();
		return Response.accepted().build();
	}
}
