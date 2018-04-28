package org.klaudi73.movies.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.klaudi73.movies.Main;
import org.klaudi73.movies.model.NameToProfession;
import org.klaudi73.movies.model.NameToTitle;
import org.klaudi73.movies.model.Profession;
import org.klaudi73.movies.model.Titles;
import org.klaudi73.movies.model.ViewPerson;
import org.klaudi73.movies.service.DataToTransferBtweenScenes;
import org.klaudi73.movies.service.MoviesAppFindService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MoviesAppAddNameController {

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
    private Label lblPerson;

    @FXML
    private TextField tfPerson;

    @FXML
    private Label lblBirthYear;

    @FXML
    private TextField tfBirthYear;

    @FXML
    private Label lblDeathYear;

    @FXML
    private TextField tfDeathYear;

    @FXML
    private Label lblProfession01;

    @FXML
    private TextField tfProfession01;

    @FXML
    private Label lblProfession02;

    @FXML
    private TextField tfProfession02;

    @FXML
    private Label lblProfession03;

    @FXML
    private TextField tfProfession03;

    @FXML
    private Label lblTitle01;

    @FXML
    private TextField tfTitle01;

    @FXML
    private Label lblTitle02;

    @FXML
    private TextField tfTitle02;
    
    @FXML
    private Label lblTitle03;

    @FXML
    private TextField tfTitle03;
    
    @FXML
    private Label lblOcena;

    @FXML
    private TextField tfOcena;

    @FXML
    private Label lblOpis;

    @FXML
    private TextArea taOpis;

    @FXML
    private Button btnAddPerson;

    @FXML
    private Button btnHome;

    @FXML
    void launchAbout(ActionEvent event) {

    }

    @FXML
    void launchAdd(ActionEvent event) {

    }

    @FXML
    void launchAddPerson(MouseEvent event) {

    }

    @FXML
    void launchClose(ActionEvent event) {

    }

    @FXML
    void launchDelete(ActionEvent event) {

    }

    @FXML
    void launchFind(ActionEvent event) {

    }

    @FXML
    void launchHome(MouseEvent event) {

    }

    @FXML
    void launchImportFromIMDB(ActionEvent event) {

    }

    @FXML
    void launchOpen(ActionEvent event) {

    }

    @FXML
    void launchView(ActionEvent event) {

    }
    
    private void setValues() {
    	System.out.println("To jest po pokazaniu okna Add Name, " + nConst);
    	MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
    	List<ViewPerson> persons = moviesAppFindService.filterPersonNConst(nConst);
    	System.out.println(persons);
    	ViewPerson person = persons.get(0);
    	tfPerson.setText(person.getName());
    	tfBirthYear.setText(person.getBirthYear().toString());
    	tfDeathYear.setText(person.getDeathYear().toString());
    	
    	List<NameToProfession> nameToProfessions = moviesAppFindService.getProfessions(nConst);
    	List<Profession> listaProf = moviesAppFindService.getProfessionNames();
    	List<String> professions = new ArrayList<String>();
    	
    	for (int i = 0; i < nameToProfessions.size(); i++) {
    		for (int j = 0; j < listaProf.size(); j++) {
    			if (nameToProfessions.get(i).getId() == listaProf.get(j).getId() ) {
    				professions.add(listaProf.get(j).getProfession());
    			}
    		}
		}
    	if (!Objects.isNull(professions.get(0))) {
    		tfProfession01.setText(professions.get(0));
    	}
    	if (!Objects.isNull(professions.get(1))) {
    		tfProfession02.setText(professions.get(1));
    	}
    	if (!Objects.isNull(professions.get(2))) {
    		tfProfession03.setText(professions.get(2));
    	}
    	
    	List<NameToTitle> titlesToName = moviesAppFindService.getNameToTitle(nConst);
    	List<Titles> titles = new ArrayList<Titles>();
    	
    	for (NameToTitle nameToTitle : titlesToName) {
    		titles.add((Titles) moviesAppFindService.getTitlesByName(nameToTitle.getTconst()));
		}
    	
    	if (!Objects.isNull(titles.get(0))) {
    		tfTitle01.setText(titles.get(0).getPrimaryTitle());
    	}
    	if (!Objects.isNull(titles.get(1))) {
    		tfTitle02.setText(titles.get(1).getPrimaryTitle());
    	}
    	if (!Objects.isNull(titles.get(2))) {
    		tfTitle03.setText(titles.get(2).getPrimaryTitle());
    	}
    	
    }
    
    public static String nConst = "";
    
    public void initialize() {
		//String nConst = (String) this.scene.getUserData();
    	//String nConst = Main.getPrimaryStage().getScene().getUserData().toString();
    	DataToTransferBtweenScenes dataToTransferBtweenScenes = new DataToTransferBtweenScenes();
    	dataToTransferBtweenScenes = Main.getDataToTransferBtweenScenes();
    	nConst = dataToTransferBtweenScenes.getData();
    	System.out.println("To jest po pokazaniu okna Add Name, " + nConst);
    	setValues();
    	//fillPersonData();
    	//fillTitleData();
    } 
}