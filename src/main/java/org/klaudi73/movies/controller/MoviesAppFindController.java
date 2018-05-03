package org.klaudi73.movies.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.Criteria;
import org.hibernate.MappingNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.klaudi73.movies.Main;
import org.klaudi73.movies.model.ViewPerson;
import org.klaudi73.movies.model.NameToTitle;
import org.klaudi73.movies.model.ViewNameTitles;
import org.klaudi73.movies.service.DataToTransferBtweenScenes;
import org.klaudi73.movies.service.MoviesAppFindService;
import org.klaudi73.movies.util.HibernateUtil;
import org.klaudi73.movies.util.ShowInformation;
import org.w3c.dom.css.ElementCSSInlineStyle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MoviesAppFindController {

    @FXML
    private Menu mnuFile;

    @FXML
    private MenuItem mnuOpen;

    @FXML
    private MenuItem mnuClose;

    @FXML
    private Menu mnuEdit;

    @FXML
    private MenuItem mnuAdd;

    @FXML
    private MenuItem mnuDelete;

    @FXML
    private Menu mnuView;

    @FXML
    private MenuItem mnuFind;

    @FXML
    private MenuItem mnuView1;

    @FXML
    private Menu mnuImport;

    @FXML
    private MenuItem mnuImportIMDB;

    @FXML
    private Menu mnuHelp;

    @FXML
    private MenuItem mnuAbout;

    @FXML
    private TextField tfPerson;

    @FXML
    private TextField tfTitle;

    @FXML
    private Button btnFind;

    @FXML
    private TableView<ViewPerson> tblName;

    @FXML
    private TableColumn<ViewPerson, String> colName;

    @FXML
    private TableColumn<ViewPerson, String> colBirthYear;

    @FXML
    private TableColumn<ViewPerson, String> colDeathYear;

    @FXML
    private TableView<ViewNameTitles> tblTitle;

    @FXML
    private TableColumn<ViewNameTitles, String> collTitle;

    @FXML
    private TableColumn<ViewNameTitles, String> colStartYear;

    @FXML
    private TableColumn<ViewNameTitles, String> colType;

    @FXML
    private TableColumn<ViewNameTitles, String> colGenres;

    @FXML
    private Button btnAddName;

    @FXML
    private Button btnAddTitle;

    @FXML
    private Button btnBack;

    @FXML
    void launchAbout(ActionEvent event) {
    	ShowInformation.showAbout();
    }

    @FXML
    void launchAdd(ActionEvent event) {

    }
    
    @SuppressWarnings("null")
	@FXML
    void launchAddName(MouseEvent event) throws IOException {
    	String nConst = tblName.getSelectionModel().getSelectedItem().getnConst();
    	System.out.println("To jest przed zmianą na okno Add Name, " + nConst);
    	DataToTransferBtweenScenes dataToTransferBtweenScenes = new DataToTransferBtweenScenes(nConst);
		Main.setDataToTransferBtweenScenes(dataToTransferBtweenScenes);
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView_AddName.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Movies Application - Add Name");
		System.out.println("To jest przed pokazaniem okna Add Name, " + nConst);
		scene.setUserData(nConst);
		Main.getPrimaryStage().setUserData(nConst);
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }
    
    @FXML
    void launchAddTitle(MouseEvent event) throws IOException {
    	String tConst = tblTitle.getSelectionModel().getSelectedItem().getTconst();
    	Main.setTransferData("tConst", tConst);
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView_AddTitle.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Movies Application - Add Title");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void launchBack(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Movies Application");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void launchClose(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void launchDelete(ActionEvent event) {

    }
    
    @FXML
    void launchTitleSelected(MouseEvent event) {
    	Scene scene = btnAddTitle.getScene();
    	scene.setCursor(Cursor.WAIT);
    	if (tblTitle.getSelectionModel().getSelectedItem() != null) {
	    	//String tConst = tblTitle.getSelectionModel().getSelectedItem().getTconst();
	    	//MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
	    	//List<ViewPerson> persons = moviesAppFindService.filterPersonByTitle(tConst);
	    	//ObservableList<ViewPerson> dataPersons = FXCollections.observableArrayList(persons);
	    	//tblName.setItems(null);
			//tblName.setItems(dataPersons);
    	}
    	scene.setCursor(Cursor.DEFAULT);
    }
    
    @FXML
    void launchNameSelected(MouseEvent event) {
    	if (tblName.getSelectionModel().getSelectedItem() != null) {
	    	//String nConst = tblName.getSelectionModel().getSelectedItem().getnConst();
	    	//MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
	    	////List<ViewPerson> persons = moviesAppFindService.filterPersonNConst(nConst);
	    	//List<ViewNameTitles> titles = moviesAppFindService.filterTitleByName(nConst);
	    	//ObservableList<ViewNameTitles> dataTitles = FXCollections.observableArrayList(titles);
	    	//tblTitle.setItems(null);
			//tblTitle.setItems(dataTitles);
    	}
    }

    @SuppressWarnings("unchecked")
	@FXML
    void launchFind(MouseEvent event) {
    	
		Scene scene = btnFind.getScene();
		scene.setCursor(Cursor.WAIT);
    	
    	String person = tfPerson.getText();
    	String title = tfTitle.getText();
    	
    	
    	MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
    	ObservableList<ViewNameTitles> dataTitles = null;
    	List<ViewPerson> listPerson = new ArrayList<ViewPerson>();
    	
    	Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction trx = session.beginTransaction();
    	
		Query queryPerson = null;
    	List<ViewPerson> persons = moviesAppFindService.filterPerson(person);
    	ObservableList<ViewPerson> dataPersons = FXCollections.observableArrayList(persons);
		
    	Query queryTitle = null;
    	List<ViewNameTitles> listNameTitles = new ArrayList<>();
    	
		List<ViewNameTitles> titles = null;
		
		if ((!Objects.isNull(title) && (!Objects.isNull(person))) || 
				("".equals(title) && "".equals(person))) {
			listNameTitles = moviesAppFindService.filterTitle(title, person);
		} else if ((!Objects.isNull(title)) && (!"".equals(title))) {
			listNameTitles = moviesAppFindService.filterTitle(title);
			for (ViewNameTitles viewNameTitles : listNameTitles) {
				String nConst = viewNameTitles.getNconst();
				queryPerson = session.createQuery("FROM ViewPerson vp WHERE vp.nConst = :nConst");
				queryPerson.setString("nConst", nConst);
				persons = queryPerson.list();
				System.out.println(persons);
				for (ViewPerson viewPerson : persons) {
					System.out.println(listPerson);
					if (!listPerson.isEmpty()) {
						if (listPerson.contains(viewPerson)) {
							//do nothing
						} else {
							listPerson.add(viewPerson);
						}
					} else {
						listPerson.add(viewPerson);
					}
				}
			} 
		} else if (!Objects.isNull(person) && (!"".equals(person))){
			listPerson = moviesAppFindService.filterPerson(person);
			for (ViewPerson viewPerson : listPerson) {
				String nConst = viewPerson.getnConst();
				queryTitle = session.createQuery("FROM NameToTitle ntt WHERE ntt.nConst = :nConst");
				queryTitle.setString("nConst", nConst);
				titles = queryTitle.list();
				System.out.println(titles);
				for ( ViewNameTitles nameToTitle : titles) {
					//System.out.println();
					if (!listNameTitles.isEmpty()) {
						if (listNameTitles.contains(nameToTitle)) {
							//do nothing
						} else {
							listNameTitles.add(nameToTitle);
						}
					} else {
						listNameTitles.add(nameToTitle);
					}
				}
			} 
		}
		dataPersons = FXCollections.observableArrayList(listPerson);
		tblName.setItems(null);
		tblName.setItems(dataPersons);
		
		dataTitles = FXCollections.observableArrayList(listNameTitles);
    	tblTitle.setItems(null);
		tblTitle.setItems(dataTitles);
		trx.commit();
		session.close();
	
		scene.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void launchImportFromIMDB(ActionEvent event) {
    	ShowInformation.showImportFromIMDB();
    }

    @FXML
    void launchOpen(ActionEvent event) {

    }

    @FXML
    void launchView(ActionEvent event) {

    }
    
    private void fillPersonData() {
    	MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
		List<ViewPerson> persons = moviesAppFindService.getAllPersons();

		ObservableList<ViewPerson> dataPersons = FXCollections.observableArrayList(persons);
		tblName.setItems(null);
		tblName.setItems(dataPersons);
	}
    
    private void fillTitleData() {
    	MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
		List<ViewNameTitles> titles = moviesAppFindService.getAllTitles();

		ObservableList<ViewNameTitles> dataTitles = FXCollections.observableArrayList(titles);
		tblTitle.setItems(null);
		tblTitle.setItems(dataTitles);
	}
    
    private void setCellValue() {

		colBirthYear.setCellValueFactory(new PropertyValueFactory<ViewPerson, String>("birthYear"));
		colDeathYear.setCellValueFactory(new PropertyValueFactory<ViewPerson, String>("deathYear"));
		colName.setCellValueFactory(new PropertyValueFactory<ViewPerson, String>("name"));
		  
		collTitle.setCellValueFactory(new PropertyValueFactory<ViewNameTitles, String>("title"));
		colStartYear.setCellValueFactory(new PropertyValueFactory<ViewNameTitles, String>("startYear"));
		colGenres.setCellValueFactory(new PropertyValueFactory<ViewNameTitles, String>("genres"));
		colType.setCellValueFactory(new PropertyValueFactory<ViewNameTitles, String>("titleType"));
	}
    
    public void initialize() {
    	
    	setCellValue();
    	fillPersonData();
    	fillTitleData();
    }

}
