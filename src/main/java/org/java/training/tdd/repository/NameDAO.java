package org.java.training.tdd.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.java.training.tdd.config.HibernateUtil;
import org.java.training.tdd.model.StudentNames;
import org.springframework.stereotype.Component;
@Component
public class NameDAO {

	public StudentNames getNameFromTableAsBean(Integer id) {
		  Transaction transaction = null;
		  StudentNames names=null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         transaction = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<StudentNames> query = builder.createQuery(StudentNames.class);
	         Root<StudentNames> root = query.from(StudentNames.class);
	         query.select(root);
	         Query<StudentNames> q=session.createQuery(query);
	          names=q.getSingleResult();
	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
			return names;
	}

	public Object getNameFromTableAsString() {
		return null;
	}

	public Integer getDocumentId() {
		Integer documentId=0;
		 Transaction transaction = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	         transaction = session.beginTransaction();

	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
	         Root<StudentNames> root = query.from(StudentNames.class);
	         query.select(root.get("id"));
	         query.where(builder.equal(root.get("firstName"), "sanjay"));
	         Query<Integer> q=session.createQuery(query);
	         documentId=q.getSingleResult();
	         transaction.commit();
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	      }
	      return documentId;
	}
	

}
