package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BonDebitController {

    @FXML
    private Button retour;

    private Button valider;

    @FXML
    void onActionRetour(ActionEvent event) {

    }

    @FXML
    void onClickValider(ActionEvent event) {

    }


    void OnClickRetour(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("InterfaceAdmin.fxml");

    }

}
