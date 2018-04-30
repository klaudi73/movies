package org.klaudi73.movies.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ShowAbout {
	
	static public void showAbout() {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("About");
		info.setHeaderText("Informacja o aplikacji movies.");
		info.setContentText("Aplikacja pozwalająca na klasyfikowanie " +
				"filmów/seriali oraz osób zaangażowanych w ich produkcję.\n" +
				"Aplikacja wykorzystuje dane z bazy IMDB.");
		info.show();
	}
}
