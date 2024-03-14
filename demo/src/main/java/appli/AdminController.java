package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    void onClickRetour(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("interfaceAdmin");
    }

    @FXML
    void onClickSuprimer(ActionEvent event) {

    }

}
