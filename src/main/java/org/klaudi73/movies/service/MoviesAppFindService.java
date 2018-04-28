package org.klaudi73.movies.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SortingFocusTraversalPolicy;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.klaudi73.movies.model.ViewPerson;
import org.klaudi73.movies.model.NameToProfession;
import org.klaudi73.movies.model.NameToTitle;
import org.klaudi73.movies.model.Profession;
import org.klaudi73.movies.model.Titles;
import org.klaudi73.movies.model.ViewNameTitles;
import org.klaudi73.movies.service.MoviesAppFindService;
import org.klaudi73.movies.util.HibernateUtil;

import javafx.collections.ObservableList;


public class MoviesAppFindService {
	
	public List<ViewPerson> getAllPersons() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewPerson");
		query.setMaxResults(100);
		
		List<ViewPerson> persons = query.list();
		trx.commit();
		session.close();
		return persons;
	}
	
	public List<ViewNameTitles> getAllTitles() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewNameTitles");
		query.setMaxResults(100);
		
		List<ViewNameTitles> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	
	public List<ViewPerson> filterPerson(String person) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewPerson where name like :person");
		query.setString("person", "%" + person + "%");
		query.setMaxResults(100);
		
		List<ViewPerson> persons = query.list();
		trx.commit();
		session.close();
		return persons;
	}
	
	public List<ViewPerson> filterPersonNConst(String nConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewPerson where nConst = :nConst");
		query.setString("nConst", nConst);
		query.setMaxResults(100);
		
		List<ViewPerson> persons = query.list();
		trx.commit();
		session.close();
		return persons;
	}
	
	public List<ViewNameTitles> filterTitle(String title) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewNameTitles where title like :title");
		query.setString("title", "%" + title + "%");
		query.setMaxResults(100);
		
		List<ViewNameTitles> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	public List<ViewNameTitles> filterTitle(String title, String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewNameTitles where primaryName like :name and title like :title");
		query.setString("name", "%" + name + "%");
		query.setString("title", "%" + title + "%");
		query.setMaxResults(100);
		
		List<ViewNameTitles> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	public List<ViewNameTitles> filterTitleByName(String nConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM ViewNameTitles where nConst = :nConst");
		query.setString("nConst", nConst);
		query.setMaxResults(100);
		
		List<ViewNameTitles> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	public List<NameToProfession> getProfessions(String nConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM NameToProfession where nConst = :nConst");
		query.setString("nConst", nConst);
		query.setMaxResults(3);
		
		List<NameToProfession> professions = query.list();
		trx.commit();
		session.close();
		return professions;
	}
	
	public List<Profession> getProfessionNames() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		List<Profession> listaProf = new ArrayList<Profession>();
    	
    	Query queryProfession = session.createQuery("from Profession p");
    	listaProf = queryProfession.list();
    	return listaProf;
	}
	
	public List<NameToTitle> getNameToTitle(String nConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM NameToTitle where nConst = :nConst");
		query.setString("nConst", nConst);
		query.setMaxResults(3);
		
		List<NameToTitle> titles = query.list();
		trx.commit();
		session.close();
		return titles;
	}
	
	public Titles getTitlesByName(String tConst) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		Query query = session.createQuery("FROM Titles where tConst = :tConst");
		query.setString("tConst", tConst);
		query.setMaxResults(1);
		
		List<Titles> titles = query.list();
		trx.commit();
		session.close();
		return titles.get(0);
	}
	
}
