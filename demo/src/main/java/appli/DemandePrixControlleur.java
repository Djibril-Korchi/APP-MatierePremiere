package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DemandePrixControlleur {

    @FXML
    private Button valider;

    @FXML
    void onClickValider(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("interface");
    }

}
