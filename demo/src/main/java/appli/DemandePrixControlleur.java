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
    void onClickRetour(ActionEvent event) throws SQLException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("interface");
    }

<<<<<<< HEAD

    public void onClickValider(ActionEvent actionEvent) {
    }
=======
    public void onClickValider(ActionEvent actionEvent) {
    }

    public void onClickRetour(ActionEvent actionEvent) {
    }
>>>>>>> ebd0572aef5a7b88592a409922d0dc11d751bd80
}
