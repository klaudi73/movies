package org.klaudi73.movies.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.klaudi73.movies.model.NameToProfession;
import org.klaudi73.movies.model.NameToTitle;
import org.klaudi73.movies.model.Names;
import org.klaudi73.movies.model.Profession;
import org.klaudi73.movies.model.Titles;

public class ImportFromIMDB {
	
	//Session session = HibernateUtil.getSessionFactory().openSession();
	//Transaction trx = session.beginTransaction();
	
	//Names name = new Names(nconst, primaryName, birthYear, deathYear);
	//session.save(name);
	
	//NameToTitle nameToTitle = new NameToTitle(nconst, tconst);
	//session.save(nameToTitle);
	
	
	//Query query = session.createQuery("FROM TematySzkolen");
	
	//List<Name> listName = query.list();
	//ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
	//List<NameToTitle> listNameToTitle = query.list();
	//List<Profession> listProfession = query.list();
	//List<Titles> listTitles = query.list();
	
	@SuppressWarnings({ "null", "unused", "resource" })
	public static void importTitles() throws FileNotFoundException {
		
		int i=0;
		
		Session session = null;
		Transaction trx = null;
		
		System.out.println("\nCzytamy z pliku title.basics.tsv\n");
		File titlesFile = new File("src\\main\\java\\org\\klaudi73\\movies\\files\\title.basics.tsv");
		
		Scanner sc1 = new Scanner(titlesFile, "UTF-8");
		Long counter = 0L;
		int countCommitedRecords = 2500000;
		Long commitCount = 100000L;
		Long counterBig = (Long)(countCommitedRecords / commitCount);
		String tmpString = new String();
		
		while(sc1.hasNext()) {
			tmpString = sc1.nextLine();
			i++;
			if (i%1000 == 0) {
				System.out.println(i);
			}
		}
		sc1 = new Scanner(titlesFile, "UTF-8");
		
		if (countCommitedRecords > 0) {
			for( i=0; i< countCommitedRecords; i++) {
				tmpString = sc1.nextLine();
			}
		}
		System.out.println(i);
		
		Double liczbaRekordow = Double.valueOf(Long.toString((long)(i)));
		Double procent = 0.0D;
		Long procentLong = 0L;
		String line = new String();
		String listaPol[] = new String[9];
		Query queryExists = null;
		Query queryCheck = null;
		
		session = HibernateUtil.getSessionFactory().openSession();
		while(sc1.hasNextLine()) {
			if (counter == 0L) {
				trx = session.beginTransaction();
				//queryCheck = session.createQuery("select :start, :end from Titles t.tconst ");
				//queryCheck.setString("start", commitCount.toString());
				//queryCheck.setString("end", commitCount.toString());
				//Criteria criteria = session.createCriteria(Titles.class);
				//criteria.setFirstResult((int)(counterBig * commitCount));
				//criteria.setMaxResults(Integer.parseInt(commitCount.toString()));
				//listaTconst = criteria.list();
			}
			counter++;
			procentLong = counterBig * commitCount + counter;
			
			procent = (Double.valueOf(procentLong.toString()) / liczbaRekordow) * 100D;
			System.out.println(((counterBig*commitCount + counter)) + " ; " + (((counterBig*commitCount + counter) / liczbaRekordow) * 100L));
			
			//line = null;
			line = sc1.nextLine();
			//for (i=0; i<9; i++) {
			//	listaPol[i] = null;
			//}
			listaPol = line.split("\t");
			for (i=0; i<9; i++) {
				listaPol[i] = listaPol[i].trim();
				if ("\\N".equals(listaPol[i])) {
					listaPol[i] = "";
				}
				if ("null".equals(listaPol[i])) {
					listaPol[i] = "";
				}
			}
			//tconst, titleType, primaryTitle, originalTitle
			//isAdult, startYear, endYear, runtimeMinutes, genres
			
			//Titles title = new Titles(
//					listaPol[0], listaPol[1], listaPol[2],
//					listaPol[3], listaPol[4], listaPol[5],
//					listaPol[6], listaPol[7], listaPol[8]
//					);
			
			Titles title = new Titles(listaPol);
			//queryExists = session.createQuery("select 1 from Titles t where t.tconst = :tconst");
			//queryExists.setString("tconst", title.getTconst());
			//listaTconst.contains(title);
			//Titles title = new Titles(tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres);
			//if (queryExists.uniqueResult() != null) {
			//if (listaTconst.contains(title)) {
				//session.update(title);
			//} else {
				session.save(title);
			//}
			//System.out.println(title);
			if (counter >= commitCount) {
				trx.commit();
				counter = 0L;
				counterBig++;
				System.out.println("counterBig = " + counterBig.toString());
			}
		}
		sc1.close();
		trx.commit();
		session.close();
		System.out.println("counter = " + counter.toString());
		System.out.println("counterBig = " + counterBig.toString());
		//Titles title = new Titles(tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres);
	}
	
	@SuppressWarnings({ "null", "unused", "resource", "unchecked" })
	public static void importNames() throws FileNotFoundException {
		
		int i=0;
		
		Session session = null;
		Transaction trx = null;
		Query queryExists = null;
		
		Long startTime = System.currentTimeMillis();
		Long endTime = System.currentTimeMillis();
		
		System.out.println(System.currentTimeMillis());
		System.out.println("\nCzytamy z pliku name.basics.tsv\n");
		//File titlesFile = new File("/movies/src/main/resources/files/name.basics.tsv");
		File namesFile = new File("src\\main\\java\\org\\klaudi73\\movies\\files\\name.basics.tsv");
		///movies/src/main/java/org/klaudi73/movies/files/name.basics.tsv
		
		Scanner sc1 = new Scanner(namesFile, "UTF-8");
		Long counter = 0L;
		int countCommitedRecords = 8654039;
		int countRecordsToCommit = 500000;
		int countRecordsCommitedInSession = 0;
		
		Long commitCount = 100000L;
		Long counterBig = (Long)(countCommitedRecords / commitCount);
		String tmpString = new String();
		
		while(sc1.hasNext()) {
			tmpString = sc1.nextLine();
			i++;
			if (i%1000 == 0) {
				System.out.println(i);
			}
		}
		Double liczbaRekordow = Double.valueOf(Long.toString((long)(i)));
		sc1 = new Scanner(namesFile, "UTF-8");
		
		if (countCommitedRecords > 0) {
			for( i=0; i < countCommitedRecords; i++) {
				tmpString = sc1.nextLine();
			}
		}
		System.out.println(i);
		
		Double procent = 0.0D;
		Long procentLong = 0L;
		String line = new String();
		String listaPol[] = new String[6];
		String listaNames[] = new String[4];
		String listaProfession[] = new String[1];
		List<Profession> listaProf = new ArrayList<Profession>();
		List<Titles> listaTitle = new ArrayList<Titles>();
		Profession profession = new Profession();
		
		Long idProfession = new Long(0);
		String listaTitles[] = new String[1];
		String tconst = "";
		
		session = HibernateUtil.getSessionFactory().openSession();
		Query queryProfession = session.createQuery("from Profession p");
		listaProf = queryProfession.list();
		while(sc1.hasNextLine()) {
			if (counter == 0L) {
				trx = session.beginTransaction();
			}
			counter++;
			if (countRecordsCommitedInSession >= countRecordsToCommit) {
				break;
			}
			//System.out.println(((counterBig*commitCount + counter)) + " ; " + (((counterBig*commitCount + counter) / liczbaRekordow) * 100L));
			
			line = sc1.nextLine();
			listaPol = line.split("\t");
			for (i=0; i<6; i++) {
				listaPol[i] = listaPol[i].trim();
				if ("\\N".equals(listaPol[i])) {
					listaPol[i] = "";
				}
				if ("null".equals(listaPol[i])) {
					listaPol[i] = "";
				}
			}
			for(i=0;i<4;i++) {
				listaNames[i] = listaPol[i];  
			}
			Names name = new Names(listaNames);
			session.save(name);
			countRecordsCommitedInSession++;
			if (listaPol[4].contains(",")) {
				listaProfession = listaPol[4].split(",");
			} else {
				listaProfession[0] = listaPol[4];
			}
			boolean existProfession = false;
			if (!Objects.isNull(listaProfession)) {
				for (String string : listaProfession) {
					profession = new Profession(string);
					for (Profession prof : listaProf) {
						//System.out.println("prof       : " + prof);
						//System.out.println("profession : " + profession);
						if (!Objects.isNull(profession.getProfession())) {
							if (profession.getProfession().equals(prof.getProfession())) {
								existProfession = true;
							//break;
							}
						} 
					}
				
					if(existProfession) {
						//do nothing
					} else {
						session.save(profession);
						listaProf.add(profession);
					}
					NameToProfession nameToProfession = new NameToProfession(name.getNconst(), profession.getId());
					session.save(nameToProfession);
				}
			}
			if (listaPol[5].contains(",")) {
				listaTitles = listaPol[5].split(",");
			} else {
				if (!Objects.isNull(listaPol[5])) {
					listaTitles[0] = listaPol[5];
				} else {
					listaTitles[0] = null;
				}
			}
			for (String string : listaTitles) {
				//queryExists = session.createQuery("from Titles t where t.tconst = :tconst");
				//queryExists.setString("tconst", string);
				//if (queryExists.uniqueResult() != null) {
					//listaTitle = queryExists.list();
					//System.out.println(listaTitle);
					//for (Titles ttconst : listaTitle) {
					NameToTitle nameToTitle = new NameToTitle(name.getNconst(), string);
					session.save(nameToTitle);
					//}					
				//} 
			}			
			if (counter >= commitCount) {
				trx.commit();
				counter = 0L;
				counterBig++;
				procentLong = counterBig * commitCount + counter;
				procent = (Double.valueOf(procentLong.toString()) / liczbaRekordow) * 100D;
				System.out.println("counterBig = " + counterBig.toString());
				System.out.println("countRecordsCommitedInSession = " + countRecordsCommitedInSession);
				System.out.println(procentLong.toString() + " ; " + procent.toString());
				System.out.println("startTime = " + startTime);
				endTime = System.currentTimeMillis();
				System.out.println("nowTime = " + endTime);
				System.out.println("Time elapsed = " + ((endTime-startTime)/1000L) + " [s]");
			}
		}
		sc1.close();
		trx.commit();
		session.close();
		
		System.out.println("counter = " + counter.toString());
		System.out.println("counterBig = " + counterBig.toString());
		System.out.println("countRecordsCommitedInSession = " + countRecordsCommitedInSession);
		System.out.println("startTime = " + startTime);
		endTime = System.currentTimeMillis();
		System.out.println("endTime = " + endTime);
		System.out.println("Time elapsed = " + ((endTime-startTime)/1000L) + " [s]");
	}
}
