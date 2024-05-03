package appli;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class BonCommandeControlleur {

    @FXML
    private Button retour;

    @FXML
    private Button valider;

    @FXML
    void onClickRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();

    }

    @FXML
    void onClickValider(ActionEvent event) {


    }
}
