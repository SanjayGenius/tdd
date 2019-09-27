package org.java.training.tdd.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.java.training.tdd.model.NameModel;
import org.java.training.tdd.repository.NameDAO;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.minidev.json.JSONObject;

class NameServiceTest {
	private NameDAO dao;
	private NameModel name;
	private NameService nameService;

	@BeforeEach
	void setUp() {
		dao = mock(NameDAO.class);
		nameService = new NameService(dao);
	}

	@Test
	void returnName() throws JSONException {
		name = new NameModel("sanjay");
		System.out.println(name);
		when(dao.getDocumentId()).thenReturn(2);
		when(dao.getNameFromTableAsBean(2)).thenReturn(name);
		//when(dao.getNameFromTableAsString()).thenReturn("SUCCESS");
		//assertThat(dao.getNameFromTableAsBean()).isEqualTo( name);
		//when(name.getName()).thenReturn("sanjay");
		JSONObject obj = new JSONObject();
		obj.put("name", "sanjay");
		obj.put("status", "success");
		assertThat(nameService.getNameFromTable()).isEqualTo(obj);
	}
}