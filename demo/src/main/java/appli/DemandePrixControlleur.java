package appli;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DemandePrixControlleur implements Initializable {

    @FXML
    private Button valider;

    @FXML
    void onClickRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
    }
    public void onClickValider(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
