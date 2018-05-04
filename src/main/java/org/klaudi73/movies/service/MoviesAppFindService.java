package org.klaudi73.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.klaudi73.movies.model.ViewPerson;
import org.klaudi73.movies.model.ViewTitle;
import org.klaudi73.movies.model.NameToProfession;
import org.klaudi73.movies.model.NameToTitle;
import org.klaudi73.movies.model.Names;
import org.klaudi73.movies.model.PersonsPriv;
import org.klaudi73.movies.model.Profession;
import org.klaudi73.movies.model.Titles;
import org.klaudi73.movies.model.TitlesPriv;
import org.klaudi73.movies.model.ViewNameTitles;
import org.klaudi73.movies.service.MoviesAppFindService;
import org.klaudi73.movies.util.HibernateUtil;

public class MoviesAppFindService {
	
	private static final int SETMAXRESULTS = 1000;
	@SuppressWarnings("unchecked")
	public List<ViewPerson> getAllPersons() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewPerson");
		query.setMaxResults(SETMAXRESULTS);
		
		List<ViewPerson> persons = query.list();
		trx.commit();
		session.close();
		return persons;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewNameTitles> getAllTitles() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewNameTitles");
		query.setMaxResults(SETMAXRESULTS);
		
		List<ViewNameTitles> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewPerson> filterPerson(String person) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		
		Query query = session.createQuery("FROM ViewPerson WHERE name LIKE :person");
		query.setString("person", "%" + person + "%");
		query.setMaxResults(SETMAXRESULTS);
		
		List<ViewPerson> persons = query.list();
		trx.commit();
		session.close();
		return persons;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewPerson> filterPersonNConst(String nConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewPerson WHERE nConst = :nConst");
		query.setString("nConst", nConst);
		query.setMaxResults(SETMAXRESULTS);
		
		List<ViewPerson> persons = query.list();
		trx.commit();
		session.close();
		return persons;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewTitle> filterViewTitle(String tConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewTitle WHERE tConst = :tConst");
		query.setString("tConst", tConst);
		query.setMaxResults(SETMAXRESULTS);
		
		List<ViewTitle> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewNameTitles> filterTitle(String title) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewNameTitles WHERE title LIKE :title");
		query.setString("title", "%" + title + "%");
		query.setMaxResults(SETMAXRESULTS);
		
		List<ViewNameTitles> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewNameTitles> filterTitle(String title, String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewNameTitles WHERE primaryName LIKE :name AND title LIKE :title");
		query.setString("name", "%" + name + "%");
		query.setString("title", "%" + title + "%");
		query.setMaxResults(SETMAXRESULTS);
		
		List<ViewNameTitles> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewPerson> filterPersonByTitle(String tConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM NameToTitle WHERE tConst = :tConst");
		query.setString("tConst", tConst);
		query.setMaxResults(1000);
		List<NameToTitle> listNameToTitle = query.list();
		List<ViewPerson> persons = new ArrayList<ViewPerson>();
		
		for (NameToTitle nameToTitle : listNameToTitle) {
			persons.add((ViewPerson) filterPersonNConst(nameToTitle.getNconst()));
		}
		trx.commit();
		session.close();
		return persons;
	}
	
	@SuppressWarnings("unchecked")
	public List<ViewNameTitles> filterTitleByName(String nConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewNameTitles WHERE nConst = :nConst");
		query.setString("nConst", nConst);
		query.setMaxResults(SETMAXRESULTS);
		
		List<ViewNameTitles> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	@SuppressWarnings("unchecked")
	public List<NameToProfession> getProfessions(String nConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM NameToProfession WHERE nConst = :nConst");
		query.setString("nConst", nConst);
		query.setMaxResults(3);
		
		List<NameToProfession> professions = query.list();
		trx.commit();
		session.close();
		return professions;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Profession> getProfessionNames() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		List<Profession> listaProf = new ArrayList<Profession>();
    	
    	Query queryProfession = session.createQuery("FROM Profession");
    	listaProf = queryProfession.list();
    	trx.commit();
    	return listaProf;
	}
	
	@SuppressWarnings("unchecked")
	public List<NameToTitle> getNameToTitle(String nConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM NameToTitle WHERE nConst = :nConst");
		query.setString("nConst", nConst);
		query.setMaxResults(3);
		
		List<NameToTitle> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	@SuppressWarnings("unchecked")
	public Titles getTitlesByName(String tConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM Titles WHERE tConst = :tConst");
		query.setString("tConst", tConst);
		query.setMaxResults(1);
		
		List<Titles> titles = query.list();
		trx.commit();
		session.close();
		return titles.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getPersonsByTitle(String tConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM NameToTitle WHERE tConst = :tConst");
		query.setString("tConst", tConst);
		//query.setMaxResults(30);
		List<NameToTitle> names = query.list();
		System.out.println(names);
		List<String> result = new ArrayList<>();
		int elements;
		if (names.size() <= 3) {
			elements = names.size();
		} else {
			elements = 3;
		}
		for (int j = 0; j < elements; j++) {
			query = session.createQuery("FROM Names WHERE nConst = :nConst");
			query.setString("nConst", names.get(j).getNconst());
			List<Names> tmpNames = query.list();
			for (Names names2 : tmpNames) {
				result.add(names2.getPrimaryName());
			}
		}
		trx.commit();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<PersonsPriv> filterPersonsByLoginId(Long idLogin) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction trx = session.beginTransaction();
    	
		Query queryPerson = session.createQuery("FROM PersonsPriv WHERE idLogin = :idLogin");
		queryPerson.setLong("idLogin", idLogin);
		List<PersonsPriv> personsPrivs = queryPerson.list();
		trx.commit();
		session.close();
		return personsPrivs;
	}

	@SuppressWarnings("unchecked")
	public List<TitlesPriv> filterTitlesByLoginId(Long idLogin) {

		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction trx = session.beginTransaction();
    	
		Query queryTitle = session.createQuery("FROM TitlesPriv WHERE idLogin = :idLogin");
		queryTitle.setLong("idLogin", idLogin);
		List<TitlesPriv> titlesPrivs = queryTitle.list();
		trx.commit();
		session.close();
		return titlesPrivs;
	}

	@SuppressWarnings("unchecked")
	public boolean existTitlePriv(TitlesPriv titlesPrivAdd) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction trx = session.beginTransaction();
    	
		Query queryTitle = session.createQuery("FROM TitlesPriv WHERE tConst = :tConst AND idLogin = :idLogin");
		queryTitle.setString("tConst", titlesPrivAdd.getTconst());
		queryTitle.setLong("idLogin", titlesPrivAdd.getIdLogin());
		List<TitlesPriv> titlesPrivs = queryTitle.list();
		trx.commit();
		session.close();
		if (titlesPrivs.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
