package appli;

import appli.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class AdminController {

    @FXML
    private Button ajouter;

    @FXML
    private Button modifier;

    @FXML
    private Button retour;

    @FXML
    private Button supprimer;

    @FXML
    void onClickAjouter(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("FormulaireAjouterUser");
    }

    @FXML
    void onClickModifier(ActionEvent event) {

    }

    @FXML
    void onActionRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
    }

    @FXML
    void onClickSuprimer(ActionEvent event) {

    }

}
