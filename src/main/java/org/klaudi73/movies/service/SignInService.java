package org.klaudi73.movies.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.klaudi73.movies.model.Login;
import org.klaudi73.movies.util.HibernateUtil;

public class SignInService {
	
	@SuppressWarnings("unchecked")
	public static Boolean checkIfLoginExist(String login) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM Login WHERE login = :login");
		query.setString("login", login);
		
		List<Login> logins = query.list();
		System.out.println(logins);
		trx.commit();
		session.close();
		//if (Objects.isNull(logins.get(0))) {
		if (logins.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void dodajLogin(Login login) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.save(login);
		trx.commit();
		session.close();
	}
}
