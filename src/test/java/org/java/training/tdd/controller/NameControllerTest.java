package org.java.training.tdd.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.java.training.tdd.service.NameService;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
@WebMvcTest
@ExtendWith(SpringExtension.class) //annotation to tell JUnit 5 to enable Spring support (2.1 not needed)
class NameControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NameService service;
	
	@Test
	void getName() throws Exception {
		String name = "Sanjay";
		when(service.getNameById()).thenReturn("Sanjay");
		mockMvc.perform(get("/names/{name}", name))
		.andExpect(status().isOk())
		.andExpect(content().string("Sanjay"));
	}

	@Test
	void getNameNull() throws Exception {
		String name = "Sanjay";
		when(service.getNameById()).thenReturn(null);
		mockMvc.perform(get("/names/{name}", name)).andExpect(status().isOk())
				.andExpect(content().string("EMPTY"));
	}

	@Test
	void getJSONFormat() throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("status", "success");
		obj.put("data", "Name is Sanjay");
		when(service.resultByJSON()).thenReturn(obj);
		mockMvc.perform(get("/names/getJSON", obj).accept("application/json"))
				//.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(content().json(obj.toString()))
				.andExpect(jsonPath("$.status").value("success"));
	}
	@SuppressWarnings("unchecked")
	@Test
	void getJSONFormatNull() throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("status", "failure");
		obj.put("data", "Sorry Unable to process Please contact admin");
		when(service.resultByJSON()).thenReturn(null);
		mockMvc.perform(get("/names/getJSON", obj).accept("application/json"))
			//	.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(content().json(obj.toString()))
				.andExpect(jsonPath("$.status").value("failure"));
	}
}
