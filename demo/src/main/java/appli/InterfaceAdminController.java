package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InterfaceAdminController {

    @FXML
    private Button bon;
    @FXML
    private Button Admin;

    @FXML
    void onClick(ActionEvent event) {

        HelloApplication helloApplication= new HelloApplication();
        helloApplication.sceneConnexion("bonDebit");
    }
    @FXML
    void onClickAdmin(ActionEvent event) {
        HelloApplication helloApplication= new HelloApplication();
        helloApplication.sceneConnexion("Admin");
    }
}
