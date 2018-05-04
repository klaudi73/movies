package org.klaudi73.movies.util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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
	
	public static void showZmodyfikowanoOsobelWBazie() {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Informacja");
		info.setHeaderText("Zmodyfikowano Osobę w bazie.");
		info.setContentText("Zmodyfikowano Osobę w bazie.");
		info.show();
	}
	
	public static Boolean showPodanaOsobaJuzIstnieje(String name) {
		Alert decision = new Alert(AlertType.CONFIRMATION);
		decision.setTitle("Potwierdzenie zmiany danych osoby");
		decision.setHeaderText("Osoba " + name + " istnieje w bazie.");
		decision.setContentText("Czy na pewno zmodyfikować?");
		Optional<ButtonType> result = decision.showAndWait();
		if (result.get() == ButtonType.OK){
		    return true;
		} else {
		    return false;
		}
	}
	
	static public void showDodanoTytulDoBazy() {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Informacja");
		info.setHeaderText("Dodano Tytuł do bazy.");
		info.setContentText("Dodano Tytuł do bazy.");
		info.show();
	}
	
	public static void showZmodyfikowanoTytulWBazie() {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Informacja");
		info.setHeaderText("Zmodyfikowano Tytuł w bazie.");
		info.setContentText("Zmodyfikowano Tytuł w bazie.");
		info.show();
	}
	
	public static Boolean showPodanyTytulJuzIstnieje(String name) {
		Alert decision = new Alert(AlertType.CONFIRMATION);
		decision.setTitle("Potwierdzenie zmiany tytułu");
		decision.setHeaderText("Tytuł " + name + " istnieje w bazie.");
		decision.setContentText("Czy na pewno zmodyfikować?");
		Optional<ButtonType> result = decision.showAndWait();
		if (result.get() == ButtonType.OK){
		    return true;
		} else {
		    return false;
		}
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
	
	static public void showShortLogin() {
		Alert errorL = new Alert(AlertType.ERROR);
		errorL.setHeaderText("Error");
		errorL.setContentText("Login is to short. It must contains at least 5 letters!");
		errorL.setTitle("Login to short.");
		errorL.show();
	}
	
	static public void showLoginExists() {
		Alert errorL = new Alert(AlertType.ERROR);
		errorL.setHeaderText("Error");
		errorL.setContentText("This login already exists in database. Change your login!");
		errorL.setTitle("Login exists.");
		errorL.show();
	}

	static public void showPasswordNotMatch() {
		Alert errorL = new Alert(AlertType.ERROR);
		errorL.setHeaderText("Error");
		errorL.setContentText("Password not match. You must enter the same passwords!");
		errorL.setTitle("Password not match.");
		errorL.show();
	}
	
	static public void showDodanoUzytkokwnikaDoBazy(String login) {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Informacja");
		info.setHeaderText("Dodano Użytkownika " + login + " do bazy.");
		info.setContentText("Dodano użytkownika do bazy.");
		info.show();
	}
}
