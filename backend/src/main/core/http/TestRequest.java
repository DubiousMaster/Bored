package main.core.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import main.core.db.mysql.BoredDao;

@Path("/test")
public class TestRequest {
	@GET
	public Response testMethod() {
		BoredDao dao = new BoredDao();
		dao.getActivity(0);
		return Response.accepted().build();
	}
}
