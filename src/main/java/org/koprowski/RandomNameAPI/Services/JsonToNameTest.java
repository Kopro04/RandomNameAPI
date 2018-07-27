package org.koprowski.RandomNameAPI.Services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;

import org.junit.Test;
import org.koprowski.RandomNameAPI.Models.Name;
import org.koprowski.RandomNameAPI.Services.NameService;


public class JsonToNameTest {

	@Test
	public void test() {
		List<Name> expected = new ArrayList<Name>();
		expected.add(new Name("FN1", "LN1", "Male", "USA"));
		expected.add(new Name("FN2", "LN2", "Female", "Canada"));
		
		JsonArray testData = Json.createArrayBuilder()
				.add(Json.createObjectBuilder()
						.add("name", "FN1")
						.add("surname", "LN1")
						.add("gender", "Male")
						.add("region", "USA"))
				.add(Json.createObjectBuilder()
						.add("name", "FN2")
						.add("surname", "LN2")
						.add("gender", "Female")
						.add("region", "Canada"))
				.build();
		
		NameService test = new NameService();
		List<Name> actual = test.bindJsonToName(testData);
		
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
