package controller;
import connect.IOFILE;
import java.io.IOException;
import java.util.ArrayList;

import connect.IOFILE;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Account;

public class LoginController {
	@FXML
    private Button login_button;

    @FXML
    private TextField login_email;

    @FXML
    private PasswordField login_password;

    @FXML
    private CheckBox login_remember;

    @FXML
    private Label login_warning_email;

    @FXML
    private Label login_warning_password;

    private Stage stage;
    private AnchorPane root;
    private Scene scene;

    String fileName="D:\\anhat\\Employees_Managerment-master\\ACC.txt";

    @FXML
    public void login(ActionEvent event) throws IOException {
        String email = login_email.getText();
        String password = login_password.getText();

        if (email.isEmpty() && password.isEmpty()) {
            login_warning_email.setText("Please type your email");
            login_warning_password.setText("Please type your password");
            login_warning_email.setVisible(true);
            login_warning_password.setVisible(true);
        } else if (email.isEmpty()) {
            login_warning_email.setText("Please type your email");
            login_warning_email.setVisible(true);
        } else if (password.isEmpty()) {
            login_warning_password.setText("Please type your password");
            login_warning_password.setVisible(true);
            
        } 
        /*else if (!email.equals("aaa@utc.edu.vn") || !password.equals("123")) {
            login_warning_email.setText("Please type correct your email");
            login_warning_password.setText("Please type correct your password");
            login_warning_email.setVisible(true);
            login_warning_password.setVisible(true);
        } else {
            login_warning_email.setVisible(false);
            login_warning_password.setVisible(false);
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/view/AdminHome.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }*/else if(!email.isEmpty() && !password.isEmpty()) {
            ArrayList<Account> accounts = IOFILE.readData(fileName);
            boolean check=false;
        	for (Account account : accounts) {
        	        if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
        	        	 check=true;
        	        	login_warning_email.setVisible(false);
        	            login_warning_password.setVisible(false);
        	            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        	            root = FXMLLoader.load(getClass().getResource("/view/AdminHome.fxml"));
        	            scene = new Scene(root);
        	            stage.setScene(scene);
        	            stage.show();
        	            break;
        	        }
        	    }
        	if(!check) {
        		login_warning_email.setText("Please type correct your email");
                login_warning_password.setText("Please type correct your password");
                login_warning_email.setVisible(true);
                login_warning_password.setVisible(true);
        	}
        }
    }

    @FXML
    public void toggleShowPassword(ActionEvent event) {
        if (login_remember.isSelected()) {
            login_password.setPromptText("");
            login_password.setManaged(true);
            login_password.setVisible(true);
        } else {
            login_password.setPromptText("Password");
            login_password.setManaged(false);
            login_password.setVisible(false);
        }
    }
}
