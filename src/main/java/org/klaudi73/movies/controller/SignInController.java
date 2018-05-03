package org.klaudi73.movies.controller;

import java.io.IOException;

import org.klaudi73.movies.Main;
import org.klaudi73.movies.model.Login;
import org.klaudi73.movies.service.SignInService;
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

public class SignInController {

    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField pfPass1;

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnQuit;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblPass1;

    @FXML
    private Label lblHello;

    @FXML
    private TextField tfPass;

    @FXML
    private Button btnShowPass;

    @FXML
    private Label lblHello2;

    @FXML
    private PasswordField pfPass2;

    @FXML
    private Label lblPass2;

    @FXML
    private Label lblLastNAme;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfLastName;

    @FXML
    void hidePass(MouseEvent event) {
    	pfPass1.setText(tfPass.getText());
    	tfPass.setVisible(false);
    	pfPass1.setVisible(true);
    }
    
    @FXML
    void showPass(MouseEvent event) {
    	tfPass.setText(pfPass1.getText());
    	tfPass.setVisible(true);
    	pfPass1.setVisible(false);
    }

    @FXML
    void launchLogin(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/LoginView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Login Movies");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void quitAction(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void launchAddUserToDatabase(MouseEvent event) throws IOException {
    	String login = tfLogin.getText();
    	String password = pfPass1.getText();
    	String password2 = pfPass2.getText();
    	String name = tfName.getText();
    	String lastName = tfLastName.getText();
    	
    	if (login.length() < 5) {
    		ShowInformation.showShortLogin();
    		return;
    	}
    	if (SignInService.checkIfLoginExist(login)) {
    		ShowInformation.showLoginExists();
    		return;
    	};
    	
    	if (!password.equals(password2)) {
    		ShowInformation.showPasswordNotMatch();
    		return;
    	}
    	SignInService.dodajLogin(new Login(login, name, lastName, password));
    	ShowInformation.showDodanoUzytkokwnikaDoBazy(login);
    	Parent parent = FXMLLoader.load(getClass().getResource("/org.klaudi73.movies.view/LoginView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setTitle("Login Movies");
		Main.getPrimaryStage().show();
		Main.getPrimaryStage().setScene(scene);
    }

}
