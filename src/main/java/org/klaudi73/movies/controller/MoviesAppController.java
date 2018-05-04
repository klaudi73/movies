package org.klaudi73.movies.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.klaudi73.movies.Main;
import org.klaudi73.movies.util.ShowInformation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MoviesAppController {

    @FXML
    private Menu mnuFile;

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
    private MenuItem mnuViewPersons;

    @FXML
    private MenuItem mnuViewTitles;

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
    void launchAbout(ActionEvent event) {
    	ShowInformation.showAbout();
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
    void launchAdd(ActionEvent event) {

    }

    @FXML
    void launchClose(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void launchDelete(ActionEvent event) {

    }

    @FXML
    void launchImportFromIMDB(ActionEvent event) throws FileNotFoundException {
    	//ImportFromIMDB.importTitles();
    	//ImportFromIMDB.importNames();
    	ShowInformation.showImportFromIMDB();
    }

    @FXML
    void launchView(ActionEvent event) {

    }
    
    @FXML
    void launchFind(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView_Find.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Movies Application - Find");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }

}
