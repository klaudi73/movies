package org.klaudi73.movies.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.klaudi73.movies.model.Persons;
import org.klaudi73.movies.util.HibernateUtil;

public class AddPersonService {
	
	static public void addPerson(Persons person) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.save(person);
		trx.commit();
		session.close();
	}
}
