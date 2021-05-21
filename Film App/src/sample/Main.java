package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Models.UserModel;
import sample.database.UserDB;

// yvr8v]7eJW"!AQ2b
// omdb api 64295b79

public class Main extends Application {
    private final UserDB db = new UserDB();
    private final UserModel user = new UserModel();

    @Override
    public void start(Stage primaryStage) throws Exception{
        db.output();

        user.setUsername(db.getUser());
        user.setPassword(db.getPassword());

        Parent root;

        if (db.getUser().equals(user.getUsername()) && db.getPassword().equals(user.getPassword())) {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setScene(new Scene(root, 700, 500));
        } else {
            root = FXMLLoader.load(getClass().getResource("loginform.fxml"));
            primaryStage.setScene(new Scene(root, 600, 400));
        }
        primaryStage.setTitle("Film App");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
