package gs.nick.dwsms.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/scala")
class ScalaResource {

  @GET
  @Produces(Array("text/html"))
  def myget(): String = {
    "Hell world from scala!"
  }
}
