package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BonDebitController {

    @FXML
    private Button retour;

    @FXML
<<<<<<< HEAD
    private Button valider;

    @FXML
    void onActionRetour(ActionEvent event) {

    }

    @FXML
    void onClickValider(ActionEvent event) {

=======
    void OnClickRetour(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("InterfaceAdmin.fxml");
>>>>>>> a1ae05718865038909a2dd6b04eac649aeecb05b
    }

}
