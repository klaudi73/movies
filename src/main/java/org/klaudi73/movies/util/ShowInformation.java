package org.klaudi73.movies.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ShowInformation {
	
	static public void showAbout() {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("About");
		info.setHeaderText("Informacja o aplikacji movies.");
		info.setContentText("Aplikacja pozwalająca na klasyfikowanie " +
				"filmów/seriali oraz osób zaangażowanych w ich produkcję.\n" +
				"Aplikacja wykorzystuje dane z bazy IMDB.");
		info.show();
	}
	
	static public void showImportFromIMDB() {		
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Informacja");
		info.setHeaderText("Informacja");
		info.setContentText("Wszystkie dane z bazy IMDB zostały zaimportowane");
		info.show();
	}
	
	static public void showDodanoOsobeDoBazy() {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Informacja");
		info.setHeaderText("Dodano Osobę do bazy.");
		info.setContentText("Dodano Osobę do bazy.");
		info.show();
	}
	
	static public void showError(Exception e) {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("ERROR");
		error.setHeaderText("Błąd");
		error.setContentText(e.getMessage());
		error.show();
	}	
	
	static public void showError(String error) {
		if ("login".equals(error)) {
			Alert errorL = new Alert(AlertType.ERROR);
    		errorL.setHeaderText("Error");
    		errorL.setContentText("Wrong login or password!");
    		errorL.setTitle("Login unsuccessfull");
    		errorL.show();
		}
	}
	

}
