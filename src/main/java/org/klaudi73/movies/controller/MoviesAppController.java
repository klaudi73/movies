package org.klaudi73.movies.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.klaudi73.movies.Main;
import org.klaudi73.movies.util.ImportFromIMDB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;

public class MoviesAppController {

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
    void launchAbout(ActionEvent event) {

    }

    @FXML
    void launchOpen(ActionEvent event) {

    }

    @FXML
    void launchAdd(ActionEvent event) {

    }

    @FXML
    void launchClose(ActionEvent event) {

    }

    @FXML
    void launchDelete(ActionEvent event) {

    }

    @FXML
    void launchImportFromIMDB(ActionEvent event) throws FileNotFoundException {
    	//ImportFromIMDB.importTitles();
    	//ImportFromIMDB.importNames();
    	Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Informacja");
		info.setHeaderText("Informacja");
		info.setContentText("Wszystkie dane z bazy IMDB zostały zaimportowane");
		info.show();
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
