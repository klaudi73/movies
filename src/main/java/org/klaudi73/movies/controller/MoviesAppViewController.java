package org.klaudi73.movies.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.klaudi73.movies.Main;
import org.klaudi73.movies.model.PersonsPriv;
import org.klaudi73.movies.model.TitlesPriv;
import org.klaudi73.movies.service.MoviesAppFindService;
import org.klaudi73.movies.util.ShowInformation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class MoviesAppViewController {

    @FXML
    private Menu mnuFile;

    @FXML
    private MenuItem mnuOpen;
    
    @FXML
    private MenuItem mnuLogout;

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
    private MenuItem mnuViewPersons;
    
    @FXML
    private MenuItem mnuViewTitles;

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
    private TableView<PersonsPriv> tblName;

    @FXML
    private TableColumn<PersonsPriv, String> colName;

    @FXML
    private TableColumn<PersonsPriv, Long> colBirthYear;

    @FXML
    private TableColumn<PersonsPriv, Long> colDeathYear;
   
    @FXML
    private TableColumn<PersonsPriv, Long> colRatingPerson;

    @FXML
    private TableView<TitlesPriv> tblTitle;
    
    @FXML
    private TableColumn<TitlesPriv, String> colTitle;

    @FXML
    private TableColumn<TitlesPriv, Long> colStartYear;

    @FXML
    private TableColumn<TitlesPriv, String> colType;

    @FXML
    private TableColumn<TitlesPriv, String> colGenres;

    @FXML
    private TableColumn<TitlesPriv, Long> colRatingTitle;

    @FXML
    private Button btnShowNameInBrowser;

    @FXML
    private Button btnShowTitleInBrowser;
    
    @FXML
    private Button btnBack;

    @FXML
    void launchAbout(ActionEvent event) {
    	ShowInformation.showAbout();
    }

    @FXML
    void launchAdd(ActionEvent event) {

    }

    @FXML
    void launchShowNameInBrowser(MouseEvent event) {
    	String link = "https://www.imdb.com/name/" + tblName.getSelectionModel().getSelectedItem().getNconst() + "/";
    	// przykładowy link https://www.imdb.com/name/nm0000001/
    	if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void launchShowTitleInBrowser(MouseEvent event) {
    	String link = "https://www.imdb.com/title/" + tblTitle.getSelectionModel().getSelectedItem().getTconst() + "/";
    	// przykładowy link https://www.imdb.com/title/tt0000001/
    	if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void launchAddTitle(MouseEvent event) {

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
    void launchFind(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView_Find.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Movies Application - Find");
		Main.getPrimaryStage().setScene(scene);
		Main.getPrimaryStage().show();
    }

    @FXML
    void launchImportFromIMDB(ActionEvent event) {
    	ShowInformation.showImportFromIMDB();
    }

    @FXML
    void launchNameSelected(MouseEvent event) {

    }

    @FXML
    void launchOpen(ActionEvent event) {

    }
    
    @FXML
    void launchLogout(ActionEvent event) throws IOException {
    	Main.setTransferData("login", null);
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/LoginView.fxml"));
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
		Main.getPrimaryStage().setScene(scene);
		Main.getPrimaryStage().setTitle("Login Movies");
		Main.getPrimaryStage().show();
    }

    @FXML
    void launchTitleSelected(MouseEvent event) {

    }
    
    @FXML
    void launchViewPersons(ActionEvent event) throws IOException {
    	Main.setTransferData("viewType", "persons");
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView_View.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Movies Application - View Persons");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void launchViewTitles(ActionEvent event) throws IOException {
    	Main.setTransferData("viewType", "titles");
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView_View.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Movies Application - View Titles");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }
    
    private void setValues() {
    	System.out.println("To jest po pokazaniu okna View " + viewType);
    	MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
    	
    	List<PersonsPriv> persons = new ArrayList<>();
    	ObservableList<PersonsPriv> dataPersons = FXCollections.observableArrayList();
		List<TitlesPriv> titles = new ArrayList<>(); 
		ObservableList<TitlesPriv> dataTitles = FXCollections.observableArrayList();
    	setCellValue();
    	if ("persons".equals(viewType)) {
    		tblName.setVisible(true);
    		tblName.setFocusTraversable(true);
    		btnShowNameInBrowser.setVisible(true);
    		btnShowNameInBrowser.setFocusTraversable(true);
    		tblTitle.setVisible(false);
    		tblTitle.setFocusTraversable(false);
    		btnShowTitleInBrowser.setVisible(false);
    		btnShowTitleInBrowser.setFocusTraversable(false);
    		persons = moviesAppFindService.filterPersonsByLoginId(loginId);
    		System.out.println("");
    		System.out.println(persons);
    		System.out.println("");
    		dataPersons = FXCollections.observableArrayList(persons);
    		tblName.setItems(null);
    		tblName.setItems(dataPersons);
    		
    	} else if ("titles".equals(viewType)) {
    		tblTitle.setVisible(true);
    		tblTitle.setFocusTraversable(true);
    		btnShowTitleInBrowser.setVisible(true);
    		btnShowTitleInBrowser.setFocusTraversable(true);
    		tblName.setVisible(false);
    		tblName.setFocusTraversable(false);
    		btnShowNameInBrowser.setVisible(false);
    		btnShowNameInBrowser.setFocusTraversable(false);
    		
    		titles = moviesAppFindService.filterTitlesByLoginId(loginId);
    		System.out.println("");
    		System.out.println(titles);
    		System.out.println("");
    		dataTitles = FXCollections.observableArrayList(titles);
    		tblTitle.setItems(null);
    		tblTitle.setItems(dataTitles);
    	}
    }
    
    public static String viewType = new String();
    public static Long loginId;
    public static String nConst = new String();
    public static String tConst = new String();
    
    private void setCellValue() {
    	colName.setCellValueFactory(new PropertyValueFactory<PersonsPriv, String>("name"));
    	colBirthYear.setCellValueFactory(new PropertyValueFactory<PersonsPriv, Long>("birthYear"));
		colDeathYear.setCellValueFactory(new PropertyValueFactory<PersonsPriv, Long>("deathYear"));
		colRatingPerson.setCellValueFactory(new PropertyValueFactory<PersonsPriv, Long>("rating"));
		
		colTitle.setCellValueFactory(new PropertyValueFactory<TitlesPriv, String>("name"));
		colStartYear.setCellValueFactory(new PropertyValueFactory<TitlesPriv, Long>("startYear"));
		colGenres.setCellValueFactory(new PropertyValueFactory<TitlesPriv, String>("genres"));
		colType.setCellValueFactory(new PropertyValueFactory<TitlesPriv, String>("titleType"));
		colRatingTitle.setCellValueFactory(new PropertyValueFactory<TitlesPriv, Long>("rating"));
	}
    
    
    public void initialize() {
    	viewType = (String) Main.getTransferData("viewType");
    	loginId = (Long) Main.getTransferData("login");
    	System.out.println("To jest po pokazaniu okna View " + viewType);
    	setValues();
    }
}
