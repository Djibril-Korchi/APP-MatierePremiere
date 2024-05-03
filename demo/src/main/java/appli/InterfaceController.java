package appli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class InterfaceController {

    @FXML
    private Button bon;

    @FXML
    void onClickRetour(ActionEvent event) throws SQLException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("interface");
    }

    public void onClickMaj(ActionEvent actionEvent) {
    }

    public void onClickBon(ActionEvent actionEvent) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("bonDebit");
    }

    public void onClickBdc(ActionEvent actionEvent) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("bonCommande");
    }

    public void onClickEds(ActionEvent actionEvent) {

    }
}
