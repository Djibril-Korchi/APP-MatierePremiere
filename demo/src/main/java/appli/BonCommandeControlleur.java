package appli;

import appli.HelloApplication;
import appli.user.User;
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
<<<<<<< HEAD
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("interface");
=======
        User user = new User();
        user.status();
>>>>>>> ebd0572aef5a7b88592a409922d0dc11d751bd80
    }

    @FXML
    void onClickValider(ActionEvent event) {


    }
}
