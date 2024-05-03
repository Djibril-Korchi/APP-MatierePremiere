package appli;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class MsjBddControlleur {

    @FXML
    private Button retour;

    @FXML
    void onActionRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
    }
}
