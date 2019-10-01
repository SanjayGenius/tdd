package org.java.training.tdd.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.java.training.tdd.config.HibernateUtil;
import org.java.training.tdd.model.StudentNames;
public class NameDAO {

	public StudentNames getNameFromTableAsBean(Integer id) {
		System.out.println("!!!!!!@@@@@@@@@@");
		System.out.println(HibernateUtil.getSessionFactory()+"%%%%%%%%%");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<StudentNames> cr = cb.createQuery(StudentNames.class);
		Root<StudentNames> root = cr.from(StudentNames.class);
		cr.select(root);
		 
		Query<StudentNames> query = session.createQuery(cr);
		StudentNames results = query.getSingleResult();
		return results;
	}

	public Object getNameFromTableAsString() {
		return null;
	}

	public Integer getDocumentId() {
		return null;
	}

}
