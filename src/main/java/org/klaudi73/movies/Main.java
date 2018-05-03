package org.klaudi73.movies;
	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.klaudi73.movies.model.Persons;
import org.klaudi73.movies.service.DataToTransferBtweenScenes;
import org.klaudi73.movies.util.ShowInformation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private static Stage primaryStage;
	private static DataToTransferBtweenScenes dataToTransferBtweenScenes = new DataToTransferBtweenScenes();
	private static HashMap<String, Object> transferData = new HashMap<>();
	
	public static void setTransferData(String name, Object value) {
		transferData.put(name, value);
	}
	
	public static Object getTransferData(String name) {
		return transferData.get(name);
	}
	
	public static DataToTransferBtweenScenes getDataToTransferBtweenScenes() {
		return dataToTransferBtweenScenes;
	}

	public static void setDataToTransferBtweenScenes(DataToTransferBtweenScenes dataToTransferBtweenScenes) {
		Main.dataToTransferBtweenScenes = dataToTransferBtweenScenes;
	}
	
	public static void setDataToTransferBtweenScenes(Long loginId) {
		Main.dataToTransferBtweenScenes.setLoginId(loginId);
	}
	
	public static void setDataToTransferBtweenScenes(Persons person) {
		Main.dataToTransferBtweenScenes.setPerson(person);
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
	
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/LoginView.fxml"));
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login Movies");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			ShowInformation.showError(e);
			//Alert error = new Alert(AlertType.ERROR);
			//error.setTitle("ERROR");
			//error.setHeaderText("Błąd");
			//error.setContentText(e.getMessage());
			//error.show();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
