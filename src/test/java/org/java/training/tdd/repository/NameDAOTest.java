package org.java.training.tdd.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.java.training.tdd.config.HibernateUtil;
import org.java.training.tdd.model.StudentNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class NameDAOTest {

	/*@Mock
	Session session;
	@Mock
	private HibernateUtil util;*/
	//@InjectMocks
	NameDAO dao=new NameDAO();

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getDataFromDb() {
		StudentNames names=new StudentNames();
		names.setId(1);
		names.setFirstName("sanjay");
		names.setLastName("brainy");
		names.setEmail("sanjay@gmail.com");
		 //when(util.getSessionFactory().openSession()).thenReturn(session);
		 assertThat(dao.getNameFromTableAsBean(2)).isEqualTo(names);
	}
}
