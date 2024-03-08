import appli.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BonCommandeControlleur {

    @FXML
    private Button retour;

    @FXML
    private Button valider;

    @FXML
    void OnclickRetour(ActionEvent event) {

    }

    @FXML
    void onClickValider(ActionEvent event) {
        HelloApplication helloApplication= new HelloApplication();
        helloApplication.sceneConnexion("interfaceAdmin");

    }

}
