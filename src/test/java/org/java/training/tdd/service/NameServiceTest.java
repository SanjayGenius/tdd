package org.java.training.tdd.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.java.training.tdd.model.StudentNames;
import org.java.training.tdd.repository.NameDAO;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class NameServiceTest {
	private StudentNames name;
	@Mock
    private NameDAO nDAO;
 
    @InjectMocks
    private NameService itemService;
 
    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@SuppressWarnings("unchecked")
	@Test
	void returnName() throws JSONException {
		name = new StudentNames();
		name.setFirstName("Sanjay");
		System.out.println(name);
		when(nDAO.getDocumentId()).thenReturn(1);
		when(nDAO.getNameFromTableAsBean(1)).thenReturn(name);
		JSONObject obj = new JSONObject();
		obj.put("name", "Sanjay");
		obj.put("status", "success");
		assertThat(itemService.resultByJSON()).isEqualTo(obj);
	}
			// when(dao.getNameFromTableAsString()).thenReturn("SUCCESS");
			// assertThat(dao.getNameFromTableAsBean()).isEqualTo( name);
			// when(name.getName()).thenReturn("sanjay");
}