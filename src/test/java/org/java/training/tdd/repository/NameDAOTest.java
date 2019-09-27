package org.java.training.tdd.repository;

import static org.mockito.Mockito.when;

import org.hibernate.Session;
import org.java.training.tdd.config.HibernateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class NameDAOTest {

	private HibernateUtil util;
	@Mock
	Session session;
	@InjectMocks
	NameDAO dao;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getDataFromDb() {
		when(HibernateUtil.getSessionFactory().openSession()).thenReturn(session);
	}
}
