package org.klaudi73.movies.controller;

import java.io.IOException;

import org.klaudi73.movies.Main;
import org.klaudi73.movies.service.LoginService;
import org.klaudi73.movies.util.ShowInformation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class LoginController {

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblPass;

    @FXML
    private PasswordField pfPass;

    @FXML
    private TextField tfLogin;

    @FXML
    private Label lblHello;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnQuit;
    
    @FXML
    private Button btnSignIn;

    @FXML
    private TextField tfPass;

    @FXML
    private Button btnShowPass;

    @FXML
    void hidePass(MouseEvent event) {
    	pfPass.setText(tfPass.getText());
    	tfPass.setVisible(false);
    	pfPass.setVisible(true);
    }
    
    @FXML
    void showPass(MouseEvent event) {
    	tfPass.setText(pfPass.getText());
    	tfPass.setVisible(true);
    	pfPass.setVisible(false);
    }

  
    @FXML
    void login(MouseEvent event) throws IOException {
    	
    	String login = tfLogin.getText();
    	String password = pfPass.getText();
    	boolean isLogged = loginService.login(login, password);
    	if (isLogged) {
    		Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/MoviesAppView.fxml"));
    		Scene scene = new Scene(parent);
    		Main.getPrimaryStage().setTitle("Movies Application");
			Main.getPrimaryStage().show();
    		Main.getPrimaryStage().setScene(scene);
    		
    	} else {
    		ShowInformation.showError("login");
    	}
    }
    
    @FXML
    void signIn(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/SignView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Login Movies");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
	void quitAction(MouseEvent event) {
		System.exit(0);
	}
    
    private LoginService loginService;
    
    public void initialize() {
    	loginService = new LoginService();
    }
}
