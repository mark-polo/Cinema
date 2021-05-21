package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.database.UserDB;

public class Login {
    private final UserDB db = new UserDB();

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button singUpBtn; // зарегистрироваться

    @FXML
    private Button SingInBtn; // войти



    @FXML
    void initialize() {
        setSingUpBtn();

    }

    private void setSingUpBtn() {

        singUpBtn.setOnAction(event -> {
            try {
                db.connect(loginField.getText() , passwordField.getText());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
