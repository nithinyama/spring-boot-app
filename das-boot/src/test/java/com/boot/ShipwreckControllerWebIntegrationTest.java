/**
 * 
 */
package com.boot;

import java.io.IOException;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author swathi cheela
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShipwreckControllerWebIntegrationTest {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void testFindAll() throws JsonProcessingException, IOException {
		ResponseEntity<String> response = this.restTemplate.getForEntity("/api/v1/shipwrecks", String.class);
		
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
		
		ObjectMapper objMapper = new ObjectMapper();
		JsonNode responseJson = objMapper.readTree(response.getBody());
		
		MatcherAssert.assertThat(responseJson.isMissingNode(), Matchers.is(false));
		MatcherAssert.assertThat(responseJson.toString(), Matchers.notNullValue());
	}
}
