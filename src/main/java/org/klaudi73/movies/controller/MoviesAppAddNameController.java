package org.klaudi73.movies.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.klaudi73.movies.Main;
import org.klaudi73.movies.model.NameToProfession;
import org.klaudi73.movies.model.NameToTitle;
import org.klaudi73.movies.model.PersonsPriv;
import org.klaudi73.movies.model.Profession;
import org.klaudi73.movies.model.Titles;
import org.klaudi73.movies.model.ViewPerson;
import org.klaudi73.movies.service.AddPersonService;
import org.klaudi73.movies.service.MoviesAppFindService;
import org.klaudi73.movies.util.ShowInformation;

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
    	ShowInformation.showAbout();
    }

    @FXML
    void launchAdd(ActionEvent event) {

    }

    @FXML
    void launchAddPerson(MouseEvent event) {
    	personsAdd.setIdLogin((Long)(Main.getTransferData("login")));
    	personsAdd.setDescription(taOpis.getText());
    	personsAdd.setRating(Long.valueOf(tfOcena.getText()));
    	AddPersonService.addPerson(personsAdd);
    	ShowInformation.showDodanoOsobeDoBazy();
    }

    @FXML
    void launchClose(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void launchDelete(ActionEvent event) {

    }

    @FXML
    void launchFind(ActionEvent event) {
    	
    }

    @FXML
    void launchHome(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Movies Application");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
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
    
    private void setValues() {
    	System.out.println("To jest po pokazaniu okna Add Name, " + nConst);
    	MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
    	
    	personsAdd.setNconst(nConst);
    	List<ViewPerson> persons = moviesAppFindService.filterPersonNConst(nConst);
    	System.out.println(persons);
    	ViewPerson person = persons.get(0);
    	if (!Objects.isNull(person.getName())) {
    		tfPerson.setText(person.getName());
    		personsAdd.setName(person.getName());
    	}
    	if (!Objects.isNull(person.getBirthYear())) {
    		tfBirthYear.setText(person.getBirthYear().toString());
    		personsAdd.setBirthYear(person.getBirthYear());
    	}
    	if (!Objects.isNull(person.getDeathYear())) {
    		tfDeathYear.setText(person.getDeathYear().toString());
    		personsAdd.setDeathYear(person.getDeathYear());
    	}
    	
    	listTextField.add(tfProfession01);
    	listTextField.add(tfProfession02);
    	listTextField.add(tfProfession03);
    	
    	List<NameToProfession> nameToProfessions = moviesAppFindService.getProfessions(nConst);
    	if (!nameToProfessions.isEmpty()) {
    		List<Profession> listaProf = moviesAppFindService.getProfessionNames();
    		List<String> professions = new ArrayList<String>();
    	
	    	for (int i = 0; i < nameToProfessions.size(); i++) {
	    		for (int j = 0; j < listaProf.size(); j++) {
	    			if (nameToProfessions.get(i).getId() == listaProf.get(j).getId() ) {
	    				professions.add(listaProf.get(j).getProfession());
	    			}
	    		}
			}
	    	
	    	for (int i=0; i<professions.size(); i++) {
				listTextField.get(i).setText(professions.get(i));
			}
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
    public static PersonsPriv personsAdd = new PersonsPriv();
    public static List<TextField> listTextField = new ArrayList<>();
    
    public void initialize() {
    	nConst = (String) Main.getTransferData("nConst");
    	setValues();
    } 
}
