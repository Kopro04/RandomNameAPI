package org.koprowski.RandomNameAPI.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koprowski.RandomNameAPI.Models.Name;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Retreives a list of JSON objects from http://uinames.com and converts
 * the JSON objects to Name objects
 * 
 * @author Michael Koprowski
 *
 */

public class NameService {
	
	
	/**
	 * Gets JSON objects from http://uinames.com
	 * @return A list of Name objects
	 */
	
	public List<Name> getRandomNames(){
		
		// Create the client that consumes the API
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://uinames.com/api/?amount=100");
		//WebTarget target = client.target("http://uinames.com/api/?amount=100&region=united%20states");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		
		// Package the list of names into a JsonArray
		JsonArray data = response.readEntity(JsonArray.class);

		response.close();
		client.close();
		
		return bindJsonToName(data);
	}
	
	
	/**
	 * Binds the data from JSON objects to Name objects
	 * @param data List of JSON objects
	 * @return List of Name objects
	 */
	
	protected List<Name> bindJsonToName(JsonArray data) {
		List<Name> names = new ArrayList<Name>();		
		ObjectMapper mapper = new ObjectMapper();
		
		try {		
			// Map each JSON object to a Name object
			for(int i = 0; i < data.size(); i++) 
				names.add(mapper.readValue(data.get(i).toString(), Name.class));
				
		}catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return names;
	}
}
