package org.klaudi73.movies.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.klaudi73.movies.model.TitlesPriv;
import org.klaudi73.movies.util.HibernateUtil;

public class AddTitlePrivService {
	
	static public void addTitlePriv(TitlesPriv titlePriv) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.save(titlePriv);
		trx.commit();
		session.close();
	}
}
