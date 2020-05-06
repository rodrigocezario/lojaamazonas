package br.edu.unifebe.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ws")
public class OlaJersey {
	
	@GET
	@Path("/ola")
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Olá com Jersey!";
	}

}
