package com.qa.person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.person.domain.Person;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
public class PersonIntegrationTest {

	@Autowired
	private MockMvc mvc; // allows us to send mock requests

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Person testPerson = new Person("Haaris", 23);
		String testPersonAsJSON = this.mapper.writeValueAsString(testPerson);

		Person testSavedPerson = new Person ("Haaris", 23);
		testSavedPerson.setId(1);
		String testSavedPersonAsJSON = this.mapper.writeValueAsString(testSavedPerson);
		
		RequestBuilder mockRequest = post("/create").content(testPersonAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();
		
		ResultMatcher checkBody = content().json(testSavedPersonAsJSON);
		//comparing the sent JSON vs received JSON
//		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
		
		//if things goes wrong run detailed comparison logging the response
		MvcResult results = this.mvc.perform(mockRequest).andExpect(checkStatus).andReturn();
		
		String responseBody = results.getResponse().getContentAsString();
		
		Person responseData = this.mapper.readValue(responseBody, Person.class);
		System.out.println("Person: " + responseData);
		
		assertThat(responseData).isEqualTo(testSavedPerson);
	}
}
