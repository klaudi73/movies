package org.klaudi73.movies.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.klaudi73.movies.model.PersonsPriv;
import org.klaudi73.movies.util.HibernateUtil;

public class AddPersonsPrivService {
	
	static public void addPersonPriv(PersonsPriv personsPriv) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.save(personsPriv);
		trx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public static Long getPersonsPrivId(PersonsPriv personsPrivAdd) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query queryTitle = session.createQuery("FROM PersonsPriv WHERE nConst = :nConst AND idLogin = :idLogin");
		queryTitle.setString("nConst", personsPrivAdd.getNconst());
		queryTitle.setLong("idLogin", personsPrivAdd.getIdLogin());
		List<PersonsPriv> personsPrivs = queryTitle.list();
		System.out.println(personsPrivs);
		trx.commit();
		session.close();
		return personsPrivs.get(0).getId();
	}

	public static void updatePersonPriv(PersonsPriv personsPrivAdd) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		System.out.println(personsPrivAdd);
		
		session.update(personsPrivAdd);
		trx.commit();
		session.close();
	}
	
}
