package org.koprowski.RandomNameAPI.Resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koprowski.RandomNameAPI.Models.Name;
import org.koprowski.RandomNameAPI.Services.NameService;


/**
 * API that is hosted using a Tomcat server and responds to get requests to 
 * http://localhost:8080/RandomNameAPI/webapi/names with a list of JSON Name
 * objects.
 * @author Michael Koprowski
 *
 */

@Path("/names")
public class NamesResource {
	
	
	/**
	 * Responds to get requests with a list of JSON name objects.
	 * @return A list of JSON name objects (Jersey converts the list of
	 * Names to JSON objects)
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Name> getNames() {
		NameService service = new NameService();
		
		return service.getRandomNames();
	}
}
