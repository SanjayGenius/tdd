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

import config.HibernateUtilTest;

public class NameDAOTest {
	//NameDAO dao=new NameDAO();
	@Mock
	private HibernateUtil util;
	@InjectMocks
	NameDAO dao;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
//	@BeforeEach
//	void setUp() {
//		dao = mock(NameDAO.class);
//		nameService = new NameService(dao);
//	}

	@Test
	public void getDataFromDb() {
		StudentNames names=new StudentNames();
		names.setId(1);
		names.setFirstName("sanjay");
		names.setLastName("brainy");
		names.setEmail("sanjay@gmail.com");
		// when(HibernateUtil.getSessionFactory().openSession()).thenReturn(HibernateUtilTest.getSessionFactory().openSession());
		 assertThat(dao.getNameFromTableAsBean(2)).isEqualToComparingFieldByField(names);
	}
}
