package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FormulaireAjoutUserController {

    @FXML
    private Button retour;

    @FXML
    void OnClickRetour(ActionEvent event) {
        HelloApplication helloApplication= new HelloApplication();
        helloApplication.sceneConnexion("Admin");
    }

}
