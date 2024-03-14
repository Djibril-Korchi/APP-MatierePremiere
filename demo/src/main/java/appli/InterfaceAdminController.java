package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InterfaceAdminController {

    @FXML
    private Button admin;

    @FXML
    private Button boncommande;

    @FXML
    private Button bonmatiere;

    @FXML
    private Button etat;

    @FXML
    private Button maj;

    @FXML
    void OnClickBonCommande(ActionEvent event) {
        HelloApplication helloApplication =new HelloApplication();
        helloApplication.sceneConnexion("bonCommande");
    }

    @FXML
    void OnClickBonMatiere(ActionEvent event) {
        HelloApplication helloApplication =new HelloApplication();
        helloApplication.sceneConnexion("bonDebit");
    }

    @FXML
    void OnclickEtat(ActionEvent event) {
        HelloApplication helloApplication =new HelloApplication();
        helloApplication.sceneConnexion("interface");
    }

    @FXML
    void OnclickMaj(ActionEvent event) {
        HelloApplication helloApplication =new HelloApplication();
        helloApplication.sceneConnexion("interface");
    }

    @FXML
    void onClickAdmin(ActionEvent event) {
        HelloApplication helloApplication =new HelloApplication();
        helloApplication.sceneConnexion("interfaceAdmin");
    }

}
