package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FilmView {

    @FXML private ImageView posterId;

    @FXML private Label labelId;

    @FXML private Label directorId;

    @FXML private Label genreId;

    @FXML private Label yearId;

    @FXML private Label runTimeId;

    @FXML private Label countryId;

    @FXML private Label ratingId;


    protected void displayLabelid(String s) {
        labelId.setText(s);
    }

    protected void displayGenreid(String s) {
        genreId.setText(s);
    }

    protected void displayDirectorid(String s) {
        directorId.setText(s);
    }

    protected void displayTimeid(String s) {
        runTimeId.setText(s);
    }

    protected void displayYearid(String s) {
        yearId.setText(s);
    }

    protected void displayCountryid(String s) {
        countryId.setText(s);
    }

    protected void displayRatingid(String s) {
        ratingId.setText(s);
    }

    protected void displayPosterid(String  s) {
        posterId.setImage(new Image(s));
        posterId.setFitHeight(360.0);
        posterId.setFitWidth(300.0);
    }
}