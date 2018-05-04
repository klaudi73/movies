package org.klaudi73.movies.service;

import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	public static Long getTitlePrivId(TitlesPriv titlesPriv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query queryTitle = session.createQuery("FROM TitlesPriv WHERE tConst = :tConst AND idLogin = :idLogin");
		queryTitle.setString("tConst", titlesPriv.getTconst());
		queryTitle.setLong("idLogin", titlesPriv.getIdLogin());
		List<TitlesPriv> titlesPrivs = queryTitle.list();
		System.out.println(titlesPrivs);
		trx.commit();
		session.close();
		return titlesPrivs.get(0).getId();
	}
	
	public static void updateTitlePriv(TitlesPriv titlesPriv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		System.out.println(titlesPriv);
		
		session.update(titlesPriv);
		//session.saveOrUpdate(titlesPriv);
		trx.commit();
		session.close();
	}
}
