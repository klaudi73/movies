package org.klaudi73.movies.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.klaudi73.movies.Main;
import org.klaudi73.movies.model.Names;
import org.klaudi73.movies.model.TitlesPriv;
import org.klaudi73.movies.model.ViewTitle;
import org.klaudi73.movies.service.AddTitlePrivService;
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

public class MoviesAppAddTitleController {

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
    private Label lblTitle;

    @FXML
    private TextField tfTitle;

    @FXML
    private Label lblStartYear;

    @FXML
    private TextField tfStartYear;

    @FXML
    private Label lblEndYear;

    @FXML
    private TextField tfEndYear;

    @FXML
    private Label lblRuntime01;

    @FXML
    private TextField tfRuntime01;

    @FXML
    private Label lbltitleType;

    @FXML
    private TextField tfTitleType;

    @FXML
    private Label lblGenres;

    @FXML
    private TextField tfGenres;

    @FXML
    private Label lblPerson01;

    @FXML
    private TextField tfPerson01;

    @FXML
    private Label lblPerson02;

    @FXML
    private TextField tfPerson02;

    @FXML
    private Label lblPerson03;

    @FXML
    private TextField tfPerson03;

    @FXML
    private Label lblOcena;

    @FXML
    private TextField tfOcena;

    @FXML
    private Label lblDescription;

    @FXML
    private TextArea taDescription;

    @FXML
    private Button btnAddTitle;

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
    void launchAddTitle(MouseEvent event) {
    	titlesPrivAdd.setIdLogin((Long)(Main.getTransferData("login")));
    	titlesPrivAdd.setDescription(taDescription.getText());
    	titlesPrivAdd.setRating(Long.valueOf(tfOcena.getText()));
    	AddTitlePrivService.addTitlePriv(titlesPrivAdd);
    	ShowInformation.showDodanoTytulDoBazy();
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
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
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
    	MoviesAppFindService moviesAppFindService = new MoviesAppFindService();
    	titlesPrivAdd.setTconst(tConst);
    	List<ViewTitle> listViewTitle = moviesAppFindService.filterViewTitle(tConst);
    	System.out.println(listViewTitle);
    	ViewTitle viewTitle = listViewTitle.get(0);
    	if (!Objects.isNull(viewTitle.getPrimaryTitle())) {
    		tfTitle.setText(viewTitle.getPrimaryTitle());
    		titlesPrivAdd.setName(viewTitle.getPrimaryTitle());
    	}
    	if (!Objects.isNull(viewTitle.getStartYear())) {
    		tfStartYear.setText(viewTitle.getStartYear().toString());
    		titlesPrivAdd.setStartYear(viewTitle.getStartYear());
    	}
    	if (!Objects.isNull(viewTitle.getEndYear())) {
    		tfEndYear.setText(viewTitle.getEndYear().toString());
    		titlesPrivAdd.setEndYear(viewTitle.getEndYear());
    	}
    	if (!Objects.isNull(viewTitle.getRuntimeMinutes())) {
    		tfRuntime01.setText(viewTitle.getRuntimeMinutes().toString());
    		titlesPrivAdd.setRuntimeMinutes(viewTitle.getRuntimeMinutes());
    	}
    	if (!Objects.isNull(viewTitle.getTitleType())) {
    		tfTitleType.setText(viewTitle.getTitleType().toString());
    		titlesPrivAdd.setTitleType(viewTitle.getTitleType());
    	}
    	if (!Objects.isNull(viewTitle.getGenres())) {
    		tfGenres.setText(viewTitle.getGenres().toString());
    		titlesPrivAdd.setGenres(viewTitle.getGenres());
    	}
    	listTextField.add(tfPerson01);
    	listTextField.add(tfPerson02);
    	listTextField.add(tfPerson03);
    	
    	List<Names> listNames = moviesAppFindService.getPersonsByTitle(tConst);
    	
    	if (!listNames.isEmpty()) {
    		for (int i=0; i<listNames.size(); i++) {
    			String tString = listNames.get(i).getPrimaryName().toString();
				listTextField.get(i).setText(tString);
			}
    	}
    }
    
    String tConst = new String();
    List<TextField> listTextField = new ArrayList<>(); 
    public static TitlesPriv titlesPrivAdd = new TitlesPriv();

    public void initialize() {
    	tConst = (String) Main.getTransferData("tConst");
    	System.out.println("To jest po pokazaniu okna Add Name, " + tConst);
    	setValues();
    } 
    
}
