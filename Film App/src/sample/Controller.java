package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Models.FilmModel;
import sample.View.FilmView;

public class Controller extends FilmView {

    private final FilmModel model = new FilmModel();

    @FXML private ResourceBundle resources;

    @FXML private URL location;

    @FXML private TextField searchField;

    @FXML private Button searchBtn;

    @FXML
    void initialize() throws IOException {
        search();
    }

    private void search () {
        searchBtn.setOnAction(event -> {

            model.setSearch(searchField.getText());

            try {
                model.film();
            } catch (IOException e) {
                e.printStackTrace();
            }

            displayLabelid(model.getTitle());

            displayGenreid(model.getGenre());

            displayDirectorid(model.getDirector());

            displayTimeid(model.getTime());

            displayYearid(model.getYear());

            displayCountryid(model.getCountry());

            displayRatingid(model.getRating());

            displayPosterid(model.getPoster());

        });
    }
}