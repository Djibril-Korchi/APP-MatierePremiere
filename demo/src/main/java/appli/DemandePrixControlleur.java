package appli;

import appli.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class DemandePrixControlleur {

    @FXML
    private Button valider;

    @FXML
    void onActionRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
    }

    public void onClickValider(ActionEvent actionEvent) {
    }

    public void onClickRetour(ActionEvent actionEvent) {
    }
}
