package org.klaudi73.movies;
	
import java.util.Objects;

import org.klaudi73.movies.service.DataToTransferBtweenScenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class Main extends Application {
	
	private static Stage primaryStage;
	private static DataToTransferBtweenScenes dataToTransferBtweenScenes;
	
	public static DataToTransferBtweenScenes getDataToTransferBtweenScenes() {
		return dataToTransferBtweenScenes;
	}

	public static void setDataToTransferBtweenScenes(DataToTransferBtweenScenes dataToTransferBtweenScenes) {
		Main.dataToTransferBtweenScenes = dataToTransferBtweenScenes;
	}

	public static Stage getPrimaryStage() {
		if (Objects.isNull(primaryStage)) {
			setPrimaryStage(primaryStage);
		}
		return primaryStage;
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			//movies/src/main/resources/org/klaudi73/movies/view/LoginView.fxml
			Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/LoginView.fxml"));
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login Movies");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("ERROR");
			error.setHeaderText("Błąd");
			error.setContentText(e.getMessage());
			error.show();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
