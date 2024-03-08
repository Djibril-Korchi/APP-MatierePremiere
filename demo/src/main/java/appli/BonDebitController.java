package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BonDebitController {

    @FXML
    private Button retour;

    @FXML
    private Button valider;

    @FXML
    void onActionRetour(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("interfaceAdmin");
    }

    @FXML
    void onClickValider(ActionEvent event) {

    }

}
